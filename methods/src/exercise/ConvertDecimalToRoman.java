package exercise;

import java.util.Scanner;

public class ConvertDecimalToRoman {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		mainLoop: while (true) {
			System.out.print("Please select mode. If you want to convert Roman numbers"
					+ " to decimal - type 'R2D' and press enter." + System.lineSeparator()
					+ "If you want to convet decimal numbers to Roman -  " + "type 'D2R' and press enter");

			String mode = scanner.next();

			if (mode.equalsIgnoreCase("R2D")) {

				while (true) {
					System.out.println("Please enter Roman number you want to conver");
					String romanNumber = scanner.next();
					if (isRomanNumberValid(romanNumber)) {
						System.out.println(romanToDecimal(romanNumber));
					} else {
						System.out.println("You entered invalid roman number" + System.lineSeparator()
								+ "Enter one of the following: 'I', 'IV', 'V', 'IX', 'X', 'XL', 'L', 'XC', 'C'");
					}

				}
			} else if (mode.equalsIgnoreCase("D2R")) {

				while (true) {
					System.out.println("Please enter deciman number you want to conver");
					int decimalNumber = scanner.nextInt();
					if (isDecimalNumberValid(decimalNumber)) {
						System.out.println(decimalToRoman(decimalNumber));
					} else {
						System.out.println("You enterd invalid decimal number!" + System.lineSeparator()
								+ "Enter positiv and less then or equal to 100");
					}
				}
			} else
				System.out.println("Please enter 'R2D' or 'D2R'");

		}

	}

	private static String decimalToRoman(int decimalNumber) {

		String[] romanArray = new String[] { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C" };
		int[] decimalArray = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100 };

		StringBuilder builder = new StringBuilder();
		for (int i = romanArray.length - 1; i >= 0; i--) {
			while (decimalNumber >= decimalArray[i]) {
				builder.append(romanArray[i]);
				decimalNumber -= decimalArray[i];
			}
		}
		return builder.toString();
	}

	private static int romanToDecimal(String romanNumber) {

		String romanNumeral = romanNumber.toUpperCase();

		int decimal = 0;
		int lastNumber = 0;

		for (int i = romanNumeral.length() - 1; i >= 0; i--) {
			char convertToDecimal = romanNumeral.charAt(i);

			switch (convertToDecimal) {
			case 'C':
				decimal = processDecimal(100, lastNumber, decimal);
				lastNumber = 100;
				break;
			case 'L':
				decimal = processDecimal(50, lastNumber, decimal);
				lastNumber = 50;
				break;
			case 'X':
				decimal = processDecimal(10, lastNumber, decimal);
				lastNumber = 10;
				break;
			case 'V':
				decimal = processDecimal(5, lastNumber, decimal);
				break;
			}
		}

		return decimal;
	}

	private static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
		if (lastDecimal > decimal)
			return lastDecimal - decimal;
		else
			return lastDecimal + decimal;
	}

	private static boolean isDecimalNumberValid(int decimalNumber) {
		return decimalNumber > 0 && decimalNumber <= 100;
	}

	private static boolean isRomanNumberValid(String romanNumber) {

		return romanNumber.matches("^(?i)M{0,3}(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$");
	}

}
