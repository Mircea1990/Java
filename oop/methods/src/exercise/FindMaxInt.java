package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxInt {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter integer numbers separated by space:");
		String numbers = scanner.nextLine();
		int[] intArray = convertStringArrayToIntArray(numbers.split("\\s+"));

		int maxInt = findMaxIntArray(intArray);
		System.out.println("*** Initial Array ***");
		System.out.println(Arrays.toString(intArray));
		System.out.println("*** Max number in array ***");
		System.out.println(maxInt);

		scanner.close();
	}

	private static int findMaxIntArray(int[] intArray) {
		return Arrays.stream(intArray).max().getAsInt();
	}

	private static int[] convertStringArrayToIntArray(String[] stringArray) {
		return Arrays.stream(stringArray).mapToInt(s -> Integer.valueOf(s)).toArray();
	}

}
