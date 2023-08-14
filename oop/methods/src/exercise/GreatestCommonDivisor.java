package exercise;

import java.util.Scanner;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter two numbers separated by space:");
		String userInput = scanner.nextLine();

		String[] inputArray = userInput.split("\\s+");
		int num1 = Integer.parseInt(inputArray[0]);
		int num2 = Integer.parseInt(inputArray[1]);

		System.out.println(gcdRecursive(num1, num2));

		scanner.close();
	}

	private static int gcdRecursive(int num1, int num2) {
		if (num2 == 0)
			return Math.abs(num1);
		else
			return gcdRecursive(num2, num1 % num2);
	}

}
