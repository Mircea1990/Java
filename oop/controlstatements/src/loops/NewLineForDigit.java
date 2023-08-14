package loops;

import java.util.Scanner;

public class NewLineForDigit {

	public static void main(String[] args) {
		System.out.println("Please enter any integer: ");

		Scanner scanner = new Scanner(System.in);
		String intString = scanner.next();
		for (char digit : intString.toCharArray())
			System.out.println(digit);

		scanner.close();
	}

}
