package exercise;

import java.util.Scanner;

public class EmptyRectangle {

	public static void main(String[] args) {
		System.out.println("Please enter height of rectangle");
		Scanner scanner = new Scanner(System.in);
		int height = scanner.nextInt();
		System.out.println("Please enter width of rectangle");
		int width = scanner.nextInt();

		drawRectangle(height, width);

		scanner.close();
	}

	private static void drawRectangle(int height, int width) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (j == 0 || j == width - 1 || i == 0 || i == height - 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}

	}

}
