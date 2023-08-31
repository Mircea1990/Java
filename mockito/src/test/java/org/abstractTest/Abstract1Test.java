package org.abstractTest;

import org.junit.Assert;
import org.junit.Test;
import org.mockingAbstractClasses.Abstract1_class;
import org.mockito.Mockito;

public class Abstract1Test {

    @Test
    public void testing_usingSpy() {
        Abstract1_class abstClass = Mockito.spy(Abstract1_class.class);

        String res = abstClass.methodUnderTest();
        Assert.assertEquals("one", res);
    }
}
