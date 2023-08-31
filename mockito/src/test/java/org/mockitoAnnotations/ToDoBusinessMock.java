package org.mockitoAnnotations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mock.ToDoBusiness;
import org.mock.ToDoService;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

/**
 * @RunWith: It is a class-level annotation. It is used to keep the test clean and improves debugging. It also detects
 * the unused stubs available in the test and initialize mocks annotated with @Mock annotation.
 * @MockitoJUnitRunner class is used to check that all the mocks are created and autowired when needed.
 */
@RunWith(MockitoJUnitRunner.class)
public class ToDoBusinessMock {

    /**
     * @Mock: It is used to mock the objects that helps in minimizing the repetitive mock objects. It makes the test
     * code and verification error easier to read as parameter names (field names) are used to identify the mocks.
     */
    @Mock
    ToDoService servicemock;

    /**
     * @InjectMocks: It marks a field or parameter on which the injection should be performed. It allows shorthand mock
     * and spy injections and minimizes the repetitive mocks and spy injection. In Mockito, the mocks are injected
     * either by setter injection, constructor injection, and property injection.
     */
    @InjectMocks
    ToDoBusiness business;

    /**
     * @Captor: It allows the creation of a field-level argument captor. It is used with the Mockito's verify() method
     * to get the values passed when a method is called.
     */
    @Captor
    ArgumentCaptor<String> argumentCaptor;

    /**
     * @Spy - It allows the creation of partially mock objects. In other words, it allows shorthand wrapping of the
     * field instances in a spy object.
     */
    @Spy
    ArrayList<String> arraylistSpy;


    @Test
    public void deleteTodosusing_BDD() {

        // Given
        List<String> combinedList = Arrays.asList("Use Hibernate Java", "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");

        given(servicemock.getTodos("dummy")).willReturn(combinedList);

        arraylistSpy.add("Mockito1");
        arraylistSpy.add("Mockito2");

        // When
        business.deleteTodosNotRelatedToHibernate("dummy");

        // Then
        verify(arraylistSpy).add("Mockito1");
        verify(arraylistSpy).add("Mockito2");
        verify(servicemock, times(1)).deleteTodos("Use Spring MVC");
        verify(servicemock, never()).deleteTodos("Use Hibernate Java");
        verify(servicemock, never()).deleteTodos("Use Hibernate");

        assertEquals(2, arraylistSpy.size());
        System.out.println("test is working..");
    }

    @Test
    public void deleteTodosusing_BDD_usingArgumentCaptor() {

        //Given
        List<String> combinedList = Arrays.asList("Use Hibernate Java",
                "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");

        given(servicemock.getTodos("dummy")).willReturn(combinedList);

        //When
        business.deleteTodosNotRelatedToHibernate("dummy");

        //Then
        then(servicemock).should().deleteTodos(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is("Use Spring MVC"));
        System.out.println("test is working..");
    }
}
