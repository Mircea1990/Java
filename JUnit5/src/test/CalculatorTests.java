package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import core.Calculator;

class CalculatorTests {

	@Test
	void test() {
		var calculator = new Calculator();

		int actual = calculator.add(2, 5);

		assertEquals(7, actual);
	}

}
