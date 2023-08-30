package org.stubbing;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ToDoBusinessTest {

    @Test
    public void getTodosSpring() {

        ToDoService doServiceStub = new ToDoServiceStub();

        ToDoBusiness business = new ToDoBusiness(doServiceStub);

        List<String> retrievedToDos = business.getTodosSpring(" Dummy ");

        assertEquals(2, retrievedToDos.size());
        System.out.println(" Stub is working correctly...!!");
    }
}