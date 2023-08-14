package loops;

public class PrintMatrixToConsole {

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3, 4, 5, 7 }, { 75, 4, 87, 7 }, { 7, 8 }, { 9, 7, 55, 3 } };

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}

	}

}
