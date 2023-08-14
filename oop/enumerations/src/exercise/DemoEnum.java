package exercise;

import java.util.Scanner;

public class DemoEnum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Please enter message type to check its priority");
			String userInput = scanner.next();

			if (isValidInput(userInput)) {
				MessageType type = MessageType.valueOf(userInput.toUpperCase());
				System.out.println(type.getPriority());
				break;
			} else {
				System.out.println("Please enter valid input like: " + "'A', 'B', 'C' or 'D'");
				continue;
			}
		}
		scanner.close();
	}

	private static boolean isValidInput(String userInput) {

		return userInput.equalsIgnoreCase("a") || userInput.equalsIgnoreCase("b") || userInput.equalsIgnoreCase("c")
				|| userInput.equalsIgnoreCase("d");
	}

}
