package generics;

public class GenericDemo1 {

	public static void main(String[] args) {
		System.out.println("Strings");
		String[] strings = { "one", "two", "three" };

		printArray(strings);

		System.out.println("\nIntegers");
		Integer[] ints = { 1, 2, 3 };
		printArray(ints);

	}

	private static <E> void printArray(E[] strings) {
		for (E element : strings) {
			System.out.print("Array element: " + element);
			System.out.println();
		}

	}

}
