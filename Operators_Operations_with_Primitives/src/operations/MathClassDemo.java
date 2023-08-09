package operations;

public class MathClassDemo {

	public static void main(String[] args) {

		System.out.println(Math.PI);
		System.out.println(Math.max(3, 5));
		System.out.println(Math.min(3, 5));
		System.out.println(Math.sqrt(4));
		int absolutValue = Math.abs(-5);
		System.out.println(absolutValue);

		System.out.println(Math.sqrt(-1));
		System.out.println(0 / 0.0);
		System.out.println((0 / 0.0) + 5);

		System.out.println(Math.round(20.0 / 3.0));
		System.out.println(Math.round(20.0 * 100.0 / 3.0) / 100.0);

		System.out.println((int) (Math.random() * 100));
		System.out.println((int) (Math.random() * 100) + 100);
	}

}
