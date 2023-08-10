package core;

public class VarargsDemo {

	public static void main(String[] args) {
		System.out.println(sum(1, 7, 8, 9, 14));
		System.out.println(sum(9, 14));
		System.out.println(sum(14));
	}

	private static int sum(int... numbers) {
		int sum = 0;
		for (int i : numbers)
			sum += i;
		return sum;
	}

}
