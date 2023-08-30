package org.mockTest;

import org.junit.Test;
import org.mock.ToDoBusiness;
import org.mock.ToDoService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


public class ToDoBusinessTestMock {

    @Test
    public void testUsingMocks() {

        ToDoService doService = mock(ToDoService.class);

        List<String> combinedList = Arrays.asList(" Use Core Java ", " Use Spring Core ", " Use w3eHibernate ", " Use Spring MVC ");
        when(doService.getTodos("dummy")).thenReturn(combinedList);

        ToDoBusiness business = new ToDoBusiness(doService);

        List<String> allTd = business.getTodosForHibernate("dummy");

        System.out.println(allTd);
        assertEquals(1, allTd.size());
    }

    @Test
    public void deleteTodosUsingBDD() {

        //Given
        ToDoService todoService = mock(ToDoService.class);

        List<String> combinedList = Arrays.asList("Use Hibernate Java", "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");

        given(todoService.getTodos("dummy")).willReturn(combinedList);

        ToDoBusiness business = new ToDoBusiness(todoService);

        //When
        business.deleteTodosNotRelatedToHibernate("dummy");

        //Then
        verify(todoService).deleteTodos("Use Spring MVC");
    }
}