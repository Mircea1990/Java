package test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)

@SelectPackages("test")

@IncludeTags("production")

@SelectClasses(JUnitApiAdvancedExamples.class)
class TestSuiteExample {

}
