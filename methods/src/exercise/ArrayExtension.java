package exercise;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayExtension {

	public static final int MULTIPLIER = 2;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter length of initial array: ");

		int baseArrayLe = scanner.nextInt();
		int[] arr = generateRandomArray(baseArrayLe);
		int[] extendedArray = extendArray(arr);

		System.out.println("*** Initial array ***");
		System.out.println(Arrays.toString(arr));

		System.out.println("*** Extended array ***");
		System.out.println(Arrays.toString(extendedArray));
		scanner.close();

	}

	private static int[] extendArray(int[] originalArray) {
		int newArrayLenght = originalArray.length * 2;
		int[] resultedArray = Arrays.copyOf(originalArray, newArrayLenght);

		for (int i = originalArray.length; i < newArrayLenght; i++) {
			resultedArray[i] = originalArray[i - originalArray.length] * MULTIPLIER;
		}
		return resultedArray;
	}

	private static int[] generateRandomArray(int baseArrayLe) {
		Random random = new Random();
		int[] resultArray = new int[baseArrayLe];
		for (int i = 0; i < baseArrayLe; i++) {
			resultArray[i] = random.nextInt(100) + 1;
		}
		return resultArray;
	}

}
