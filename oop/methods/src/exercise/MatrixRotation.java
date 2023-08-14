package exercise;

import java.util.Scanner;

public class MatrixRotation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter matrix size:");
		int size = scanner.nextInt();

		double[][] matrix = generateMatrix(size);

		System.out.println("How do you want to rotate matrix: " + System.lineSeparator() + "\t1 - 90"
				+ System.lineSeparator() + "\t2 - 180" + System.lineSeparator() + "\t3 - 270" + System.lineSeparator());

		int mode = scanner.nextInt();

		System.out.println(System.lineSeparator() + "Base matrix: ");

		printMatrixToConsole(matrix);
		System.out.println();

		if (rotateMatrix(matrix, mode))
			printMatrixToConsole(matrix);

	}

	private static boolean rotateMatrix(double[][] matrix, int mode) {
		switch (mode) {
		case 1:
			System.out.println("90 degrees rotated: ");
			rotate90(matrix);
			break;
		case 2:
			System.out.println("180 degree rotate: ");
			rotate180(matrix);
			break;
		case 3:
			System.out.println("270 degree rotate: ");
			rotate270(matrix);
			break;
		default:
			System.out.println("You selected non-existing mode!");
			return false;
		}
		return true;
	}

	private static void rotate270(double[][] matrix) {
		transposeMatrix(matrix);
		horizontalReflect(matrix);
	}

	private static void rotate180(double[][] matrix) {
		verticalReflection(matrix);
		horizontalReflect(matrix);

	}

	private static void horizontalReflect(double[][] matrix) {
		double temp;
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix.length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - 1 - i][j];
				matrix[matrix.length - 1 - i][j] = temp;
			}
		}
	}

	private static void rotate90(double[][] matrix) {
		transposeMatrix(matrix);
		verticalReflection(matrix);
	}

	private static void verticalReflection(double[][] matrix) {
		double temp;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][matrix.length - 1 - j];
				matrix[j][matrix.length - 1 - j] = temp;
			}
		}
	}

	private static void transposeMatrix(double[][] matrix) {
		double temp;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	private static void printMatrixToConsole(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static double[][] generateMatrix(int size) {
		double[][] matrix = new double[size][size];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++)
				matrix[i][j] = Double.valueOf(Integer.toString(i) + "." + Integer.toString(j));
		}
		return matrix;
	}

}
