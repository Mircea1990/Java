package test;

import org.junit.jupiter.api.Test;

import core.TestCodeCoverageDemo;

class TestCodeCoverageDemoTest {

	private TestCodeCoverageDemo testInstance = new TestCodeCoverageDemo();

	@Test
	void testStringNull() {
		testInstance.testCodeCoverage(null);
	}

	@Test
	void testNonNullString() {
		testInstance.testCodeCoverage("not null string");
	}
}
