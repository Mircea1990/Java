package loops;

public class ForeachLoopDemo {

	public static void main(String[] args) {
		System.out.println("=========== foreach loop");
		int arr[] = { 1, 4, 8, 7 };
		int sum = 0;
		for (int number : arr) {
			sum += number;
			System.out.println("Number: " + number);
		}

		System.out.println("Sum is: " + sum);

	}

}
