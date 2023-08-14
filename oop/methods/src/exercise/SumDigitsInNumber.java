package exercise;

import java.util.Scanner;

public class SumDigitsInNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter integer: ");
		int number = scanner.nextInt();

		int sumOfDigits = sumOfDigitsInNumber(number);
		System.out.println(sumOfDigits);

		scanner.close();
	}

	private static int sumOfDigitsInNumber(int number) {
		int result = 0;
		while (number != 0) {
			result += number % 10;
			number /= 10;
		}
		return Math.abs(result);
	}

}
