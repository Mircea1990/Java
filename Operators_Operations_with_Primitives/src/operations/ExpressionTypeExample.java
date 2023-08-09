package operations;

public class ExpressionTypeExample {

	public static void main(String[] args) {
		byte b = 1;
		short s = 1;
		int i = 1;
		long l = 1;

		float f = 1.0f;
		double d = 1.0;
		char c = 1;

		System.out.println(b + b);
		System.out.println(s + s);
		System.out.println(b + i + c);
		System.out.println(i + l);
		System.out.println(l + f);
		System.out.println(f + d);
		System.out.println(10 / 3);
		System.out.println(10.0 / 3);
		System.out.println("Hello " + 1);
		System.out.println("Hello " + null);
	}

}
