package generics;

public class GenericDemo3<T> {

	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public static void main(String[] args) {
		GenericDemo3<Integer> integerBox = new GenericDemo3<Integer>();
		GenericDemo3<String> stringBox = new GenericDemo3<String>();

		integerBox.setT(10);

		stringBox.setT("Hello ");

		Integer integer = integerBox.getT();
		String string = stringBox.getT();
		System.out.println("Integer value: " + integer);
		System.out.println("String value: " + string);
	}

}
