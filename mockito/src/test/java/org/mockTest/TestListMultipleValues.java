package org.mockTest;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestListMultipleValues {

    @Test
    public void testList_Returns_MultipleValues() {

        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(1).thenReturn(2).thenReturn(3);

        assertEquals(1, mockList.size());
        assertEquals(2, mockList.size());
        assertEquals(3, mockList.size());

        System.out.println(mockList.size());
        System.out.println(mockList);

    }
}
