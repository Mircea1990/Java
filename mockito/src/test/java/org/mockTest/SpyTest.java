package org.mockTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

public class SpyTest {

    @Test
    public void test() {

        List<String> spyArrayList = spy(ArrayList.class);
        assertEquals(0, spyArrayList.size());

        // adding an item in the list
        spyArrayList.add("Mockito");
        assertEquals(1, spyArrayList.size());
    }
}
