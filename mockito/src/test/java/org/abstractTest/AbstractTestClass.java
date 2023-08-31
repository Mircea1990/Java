package org.abstractTest;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbstractTestClass {

    @Test
    public void test_AbstractClasses() {

        AbstractClass ac = mock(AbstractClass.class);
        when(ac.sayMock()).thenCallRealMethod();
        when(ac.getName()).thenReturn("Jyotika");
        assertEquals("Hii.. Jyotika!!", ac.sayMock());
    }
}
