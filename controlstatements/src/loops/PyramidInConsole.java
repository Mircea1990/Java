package loops;

import java.util.Scanner;

public class PyramidInConsole {

	public static void main(String[] args) {
		System.out.println("Please enter height of the pyramid: ");
		Scanner scanner = new Scanner(System.in);
		int heigth = scanner.nextInt();

		for (int i = 0; i < heigth + 1; i++) {
			for (int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
		for (int i = heigth - 1; i > 0; i--) {
			for (int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}

		scanner.close();
	}

}
