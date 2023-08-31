package org.powerMock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mock.Utility;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Utility.class)
public class Powermock_test {

    @Test
    public void TestStaticMethod_WithPowerMockito() {

        String call = " Hi there, I'm using PowerMock with Mockito ";
        String callExpectation = " Call Expectation for you. ";

        PowerMockito.mockStatic(Utility.class);
        PowerMockito.when(Utility.staticMethod(call)).thenReturn(callExpectation);

        String actualCall = Utility.staticMethod(call);
        assertEquals(callExpectation, actualCall);
    }
}
