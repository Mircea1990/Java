package org.jUnitRules;

import org.junit.Rule;
import org.junit.Test;
import org.mock.ToDoBusiness;
import org.mock.ToDoService;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


public class ToDoBusinessMock {

    /**
     * @Rule: It annotates the fields. It refer to the rules or methods that returns a rule. The annotated fields must
     * be public, non-static, and subtypes of the
     * @TestRule or
     * @MethodRule.
     */
    @Rule
    public MockitoRule mockitorule = MockitoJUnit.rule();

    @Mock
    ToDoService serviceMock;

    @InjectMocks
    ToDoBusiness business;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    public void deleteTodosusing_BDD() {

        // Given
        List<String> combinedList = Arrays.asList("Use Hibernate Java",
                "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");

        given(serviceMock.getTodos("dummy")).willReturn(combinedList);

        // When
        business.deleteTodosNotRelatedToHibernate("dummy");

        // Then
        verify(serviceMock, times(1)).deleteTodos("Use Spring MVC");
        verify(serviceMock, never()).deleteTodos("Use Hibernate Java");
        verify(serviceMock, never()).deleteTodos("Use Hibernate");
        System.out.println("test is working..");
    }

    @Test
    public void deleteTodosusing_BDD_usingArgumentCaptor() {

        //Given
        List<String> combinedList = Arrays.asList("Use Hibernate Java",
                "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");

        given(serviceMock.getTodos("dummy")).willReturn(combinedList);

        //When
        business.deleteTodosNotRelatedToHibernate("dummy");

        //Then
        then(serviceMock).should().deleteTodos(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is("Use Spring MVC"));
        System.out.println("test is working..");
    }
}
