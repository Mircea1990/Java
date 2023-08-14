package core;

import java.util.Arrays;
import java.util.Scanner;

public class SplitWords {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any text ");
		String userInput = scanner.nextLine();
		System.out.println("You enterd these words: ");
		System.out.println(Arrays.toString(userInput.split("[\\p{P}\\s]+")));

		scanner.close();
	}

}
