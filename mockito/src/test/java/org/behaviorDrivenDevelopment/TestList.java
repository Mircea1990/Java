package org.behaviorDrivenDevelopment;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class TestList {

    @Test
    public void testList_usingBDD() {

        //Given - setup part
        List<String> mockList = mock(List.class);
        given(mockList.get(Mockito.anyInt())).willReturn("Mockito");

        //When - invocation
        String string1 = mockList.get(0);

        //Then - readable assert
        assertThat(string1, is("Mockito"));
    }
}
