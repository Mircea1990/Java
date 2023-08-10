package core;

public class RecursiveMethodsDemo {

	public static void main(String[] args) {
		// callSomeMethod(); -> StackOverflowError

		System.out.println("3!: " + calculateFactorial(3));
		System.out.println("3!: " + calculateFactorial(6));

		System.out.println("iterative factorial: " + iterativeFactorial(4));
	}

	private static int iterativeFactorial(int number) {
		int factorial = 1;
		if (number < 0)
			return -1;
		for (int i = 1; i <= number; i++)
			factorial *= number;

		return factorial;
	}

	private static int calculateFactorial(int i) {
		if (i != 0)
			return i * calculateFactorial(i - 1);
		else
			return 1;
	}

	private static void callSomeMethod() {
		callSomeMethod();
	}

}
