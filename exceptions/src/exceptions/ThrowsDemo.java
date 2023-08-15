package exceptions;

import java.io.FileNotFoundException;

public class ThrowsDemo {

	public static void main(String[] args) {
		ThrowsDemo demo = new ThrowsDemo();
		try {
			demo.someMethod();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void someMethod() throws FileNotFoundException {
		System.out.println("Some method ");
	}

	class ThrowsDemoOverride extends ThrowsDemo {

		@Override
		public void someMethod() throws FileNotFoundException {
			// TODO Auto-generated method stub
			super.someMethod();
		}

	}
}
