package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import core.Account;
import core.MoneyTransactionService;
import exceptions.NotEnoughMoneyException;

class MoneyTransactionServiceTest {

	private static final String MONEY_AMOUNT_EXCEPTION_MSG = "Money amount should be greater than 0";
	private static final String ACCOUNT_EXCEPTION_MSG = "Account shouldn't be null";
	private static final double RANDOM_MONEY_AMOUNT = 100;
	private static final double ZERO_MONEY_AMOUNT = 0;
	private static final double MORE_THAN_RANDOM_MONEY_AMOUNT = 200;
	private static final double NEGATIVE_MONEY_AMOUNT = -1;

	private MoneyTransactionService testInstance;

	@BeforeEach
	void setUp() throws Exception {
		testInstance = new MoneyTransactionService();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void souldTransferMoneyFromOneAcoountToAnother() {

		// given
		var account1 = new Account(RANDOM_MONEY_AMOUNT);
		var account2 = new Account(ZERO_MONEY_AMOUNT);

		// when
		testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT);

		// then
		assertEquals(ZERO_MONEY_AMOUNT, account1.getMoneyAmount());
		assertEquals(RANDOM_MONEY_AMOUNT, account2.getMoneyAmount());

	}

	@Test
	void souldThrowExceptionIfAccountIsNull() {

		// given
		Account account1 = null;
		Account account2 = new Account(RANDOM_MONEY_AMOUNT);

		// when & then
		var exception = assertThrows(IllegalArgumentException.class,
				() -> testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT));

		assertEquals(ACCOUNT_EXCEPTION_MSG, exception.getMessage());
	}

	@Test
	void shouldThrowExceptionIfAccountToIsNull() {

		// given
		Account account1 = new Account(RANDOM_MONEY_AMOUNT);
		Account account2 = null;

		// when & then
		var exception = assertThrows(IllegalArgumentException.class,
				() -> testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT));

		assertEquals(ACCOUNT_EXCEPTION_MSG, exception.getMessage());
	}

	@Test
	void shouldThrowNotEnoughMoneyExceptionWhenTransferMoreMoney() {

		// given
		var account1 = new Account(RANDOM_MONEY_AMOUNT);
		var account2 = new Account(ZERO_MONEY_AMOUNT);

		// when
		assertThrows(NotEnoughMoneyException.class,
				() -> testInstance.transferMoney(account1, account2, MORE_THAN_RANDOM_MONEY_AMOUNT));
	}

	@Test
	void shouldThrowExceptionWhenTransferNegativeAmount() {

		// given
		var account1 = new Account();
		var account2 = new Account();

		// when
		var exception = assertThrows(IllegalArgumentException.class,
				() -> testInstance.transferMoney(account1, account2, NEGATIVE_MONEY_AMOUNT));

		assertEquals(MONEY_AMOUNT_EXCEPTION_MSG, exception.getMessage());
	}

	@Test
	void shouldThrowExceptionWhenTransferZeroMoneyAmount() {

		// given
		var account1 = new Account();
		var account2 = new Account();

		// when
		var exception = assertThrows(IllegalArgumentException.class,
				() -> testInstance.transferMoney(account1, account2, ZERO_MONEY_AMOUNT));

		assertEquals(MONEY_AMOUNT_EXCEPTION_MSG, exception.getMessage());
	}

	// ================ Other Assertions examples from JUnit

	@Test
	void groupedAssertionsExamples() {
		// in a grouped assertion all assertions are executed and
		// all failures will be reported together

		// given
		var account1 = new Account(RANDOM_MONEY_AMOUNT);
		var account2 = new Account(ZERO_MONEY_AMOUNT);

		// when
		testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT);

		// then
		assertAll("money transaction", () -> assertEquals(ZERO_MONEY_AMOUNT, account1.getMoneyAmount()),
				() -> assertEquals(RANDOM_MONEY_AMOUNT, account2.getMoneyAmount()));
	}

	@Test
	void dependentAssertionsExample() {
		// within a code block, if an assertion fails,
		// the subsequent code in the same block will be skipped

		// given
		var account1 = new Account(RANDOM_MONEY_AMOUNT);
		var account2 = new Account(ZERO_MONEY_AMOUNT);

		assertAll("Money transaction", () -> {
			// when
			boolean isTransactionSucces = testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT);
			assertTrue(isTransactionSucces);

			// executed only if the previous assertion is valid
			assertAll("Money amount is changed on the accounts",
					() -> assertEquals(ZERO_MONEY_AMOUNT, account1.getMoneyAmount()),
					() -> assertEquals(RANDOM_MONEY_AMOUNT, account2.getMoneyAmount()));
		});
	}

	@Test
	void testWithTimeoutExample() {
		// given
		var account1 = new Account(RANDOM_MONEY_AMOUNT);
		var account2 = new Account(ZERO_MONEY_AMOUNT);

		assertTimeout(Duration.ofSeconds(0), () -> testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT));
	}

	@Test
	@Timeout(2)
	void timeoutNotExceededWithResult() {
		// given
		var account1 = new Account(RANDOM_MONEY_AMOUNT);
		var account2 = new Account(ZERO_MONEY_AMOUNT);

		boolean actualRestult = assertTimeout(Duration.ofSeconds(1), () -> {
			return testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT);
		});
		assertTrue(actualRestult);
	}

	@Test
	void testRunningOnlyOnLaptop() {
		assumeTrue("true".equals(System.getenv("IS_RUNNING_ON_LAPTOP")),
				() -> "Abording this test, because the program is not running on laptop");

		// given
		var account1 = new Account(RANDOM_MONEY_AMOUNT);
		var account2 = new Account(ZERO_MONEY_AMOUNT);

		boolean actualResult = assertTimeout(Duration.ofSeconds(1), () -> {
			return testInstance.transferMoney(account1, account2, RANDOM_MONEY_AMOUNT);
		});
		assertTrue(actualResult);
	}

	@ParameterizedTest
	@ValueSource(ints = { 100, 200, 57, -78 })
	void parametrizedTestExample(int moneyAmount) {
		assumeTrue(moneyAmount > 0, () -> "Money amount can't be negative");

		var account1 = new Account(moneyAmount);
		var account2 = new Account(ZERO_MONEY_AMOUNT);

		assertTrue(testInstance.transferMoney(account1, account2, moneyAmount));
	}

	@ParameterizedTest
	@NullSource
	@EmptySource
	@NullAndEmptySource
	void nullAndEmptySources(String test) {
		assertTrue(test == null || test.trim().isEmpty());
	}

	@ParameterizedTest
	@MethodSource("sourceMethod")
	void testMethodSource(String arg) {
		assertNotNull(arg);
	}

	static Stream<String> sourceMethod() {
		return Stream.of("John", "Alex", "Ana");
	}

	@ParameterizedTest
	@CsvSource({ "apple, 1", "banana, 2", "lemon, 3", })
	void testWithCsvSource(String fruit, int rank) {
		assertNotNull(fruit);
		assertNotEquals(0, rank);
	}
}
