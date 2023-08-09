package operations;

import java.util.Arrays;

public class PrimitiveAndRefferenceTypesComparison {

	public static void main(String[] args) {
		int i1 = 128;
		int i2 = 128;

		System.out.println(i1 == i2);
		System.out.println("1 == 2: " + (1 == 2));
		System.out.println("65 == 'A': " + (65 == 'A'));

		Integer i3 = 127;
		Integer i4 = 127;
		System.out.println("i3 == i4: " + (i3 == i4));

		Integer i5 = Integer.valueOf(127);
		Integer i6 = Integer.valueOf(127);
		System.out.println("i5 == i6: " + (i5 == i6));

		Integer i5b = new Integer(127);
		Integer i6b = new Integer(127);
		System.out.println("i5b == i6b: " + (i5b == i6b));

		System.out.println("i3.equals(i4): " + i3.equals(i4));
		System.out.println("i5b.equals(i6b): " + i5b.equals(i6b));

		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };

		System.out.println("arr1 == arr2: " + (arr1 == arr2));
		System.out.println("arr1.equals(arr2): " + arr1.equals(arr2));
		System.out.println("Arrays.equals(arr1,arr2): " + Arrays.equals(arr1, arr2));

		arr1 = arr2;
		System.out.println("arr1 == arr2: " + (arr1 == arr2));
	}

}
