package org.argumentCaptor;

import org.junit.Test;
import org.mock.ToDoBusiness;
import org.mock.ToDoService;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class ToDoBusinessMock {

    @Test
    public void deleteTodosUsingBDDUsingArgumentCaptor() {

        // Declare an Argument Captor that captures the argument of this (todoService) mock
        // when deleteTodos() method is called.
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        //Given
        ToDoService todoService = mock(ToDoService.class);

        //create a fixed-size list initialized to contain several elements
        List<String> combinedList = Arrays.asList("Use Hibernate Java",
                "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");

        given(todoService.getTodos("dummy")).willReturn(combinedList);

        ToDoBusiness business = new ToDoBusiness(todoService);

        //When
        business.deleteTodosNotRelatedToHibernate("dummy");

        //Then
        then(todoService).should().deleteTodos(argumentCaptor.capture());

        //checking whether the argument passed is "Use Spring MVC" or not
        assertThat(argumentCaptor.getValue(), is("Use Spring MVC"));
    }

    @Test
    public void deleteTodosUsingBDDUsingArgumentCaptorMultipleValues() {

        // Declare an Argument Captor that captures the argument of this (todoService) mock
        // when deleteTodos() method is called.
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        //Given
        ToDoService todoService = mock(ToDoService.class);

        //create a fixed-size list initialized to contain several elements
        List<String> combinedList = Arrays.asList("Use Hibernate Java",
                "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");

        given(todoService.getTodos("dummy")).willReturn(combinedList);
        given(todoService.getTodos("dummy2")).willReturn(combinedList);

        ToDoBusiness business = new ToDoBusiness(todoService);

        //When
        business.deleteTodosNotRelatedToHibernate("dummy");
        business.deleteTodosNotRelatedToHibernate("dummy2");

        //Then
        then(todoService).should(times(2)).deleteTodos(argumentCaptor.capture());

        //checking whether the argument passed is "Use Spring MVC" or not
        assertThat(argumentCaptor.getAllValues().size(), is(2));
    }
}
