package exercise;

import java.util.Scanner;

public class FirstCharCapital {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any text:");
		String userInput = scanner.nextLine();

		System.out.println(firstCharToTitleCase(userInput));

		scanner.close();
	}

	private static String firstCharToTitleCase(String userInput) {
		char[] chars = userInput.toLowerCase().toCharArray();
		boolean found = false;

		for (int i = 0; i < chars.length; i++) {
			if (!found && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				found = true;
			} else if (Character.isWhitespace(chars[i]))
				found = false;
		}
		return String.valueOf(chars);
	}

}
