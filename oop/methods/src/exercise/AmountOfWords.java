package exercise;

import java.util.Scanner;

public class AmountOfWords {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any text: ");
		String userInput = scanner.nextLine();

		System.out.println("Amount of user words in text is: " + getUserWordAmount(userInput));

		scanner.close();
	}

	public static int getUserWordAmount(String userInput) {
		return userInput.split("[\\p{P}\\s]+").length;
	}

}
