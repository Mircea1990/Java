package generics;

public class GenericDemo2 {

	public static void main(String[] args) {
		System.out.printf("Max if %d, %d and %d is %d\n\n", 1, 2, 3, maxValue(1, 2, 3));
		System.out.printf("Max if %.2f, %.2f and %.2f is %.2f\n\n", 1.4, 0.7, 0.3, maxValue(1.4, 0.7, 0.3));
		System.out.printf("Max if %s, %s and %s is %s\n\n", "Ford", "Mazda", "Suzuky",
				maxValue("Ford", "Mazda", "Suzuky"));

	}

	private static <T extends Comparable<T>> T maxValue(T i, T j, T k) {
		T max = i;
		if (j.compareTo(max) > 0)
			max = j;

		if (k.compareTo(max) > 0)
			max = k;

		return max;
	}

}
