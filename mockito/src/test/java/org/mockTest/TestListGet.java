package org.mockTest;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestListGet {

    @Test
    public void testList_get() {

        List mocklist = mock(List.class);

        when(mocklist.get(0)).thenReturn("Mockito");

        assertEquals("Mockito", mocklist.get(0));
        System.out.println(mocklist.get(0));
    }
}
