package com.example.factorybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

// This annotation tells JUnit to run the test using Spring's testing support.
// SpringJUnit4ClassRunner is a custom extension of JUnit's BlockJUnit4ClassRunner which provides
// functionality of the Spring TestContext Framework to standard JUnit tests.
@RunWith(SpringJUnit4ClassRunner.class)
// This annotation is used to specify the locations of configuration files to load for this test
// class.
@ContextConfiguration(locations = {"classpath:factorybean-abstract-spring-ctx.xml"})
public class AbstractFactoryBeanIntegrationTest {
    // These are private fields for the Tool objects. The @Resource annotation is used to
    // automatically wire the Tool beans with the names "singleTool" and "nonSingleTool".
    @Resource(name = "singleTool") private Tool tool1;
    @Resource(name = "singleTool") private Tool tool2;
    @Resource(name = "nonSingleTool") private Tool tool3;
    @Resource(name = "nonSingleTool") private Tool tool4;

    @Test
    // This test method checks if the 'singleTool' factory bean produces a singleton instance.
    public void testSingleToolFactory() {
        // Assert that the ID of tool1 is 1.
        assertThat(tool1.getId(), equalTo(1));
        // Assert that tool1 and tool2 refer to the same object, confirming that 'singleTool' is
        // a singleton.
        assertSame(tool1, tool2);
    }

    @Test
    // This test method checks if the 'nonSingleTool' factory bean produces a non-singleton
    // instance.
    public void testNonSingleToolFactory() {
        // Assert that the ID of tool3 is 2.
        assertThat(tool3.getId(), equalTo(2));
        // Assert that the ID of tool4 is also 2.
        assertThat(tool4.getId(), equalTo(2));
        // Assert that tool3 and tool4 do not refer to the same object, confirming that
        // 'nonSingleTool' is not a singleton.
        assertNotSame(tool3, tool4);
    }
}
