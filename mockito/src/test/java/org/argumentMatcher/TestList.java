package org.argumentMatcher;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestList {

    @Test
    public void testList_Argument_Matchers() {

        List<String> mockList = mock(List.class);

        when(mockList.get(Mockito.anyInt())).thenReturn("Mockito");

        assertEquals("Mockito", mockList.get(0));
        assertEquals("Mockito", mockList.get(1));
        assertEquals("Mockito", mockList.get(2));
    }

    @Test(expected = RuntimeException.class)
    public void testList_ThrowsException() {

        List<String> mockList = mock(List.class);

        when(mockList.get(Mockito.anyInt())).thenThrow(new RuntimeException("Error.."));
        mockList.get(0);
    }
}
