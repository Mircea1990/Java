package core;

public class MethodsDemo {

	public static void main(String[] args) {
		int sum = sum(1, 3);
		printToConsole(sum);
		printToConsole(sum(2.7, 7.7));
		printToConsole("random text");
	}

	private static void printToConsole(String text) {
		System.out.println(text);

	}

	private static void printToConsole(double sum) {
		System.out.println(sum);

	}

	private static void printToConsole(int sum) {
		System.out.println(sum);

	}

	private static double sum(double d, double e) {
		return d + e;
	}

	private static int sum(int i, int j) {
		return i + j;
	}
}
