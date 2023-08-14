package encapsulation.package1;

import encapsulation.package2.ClassB;

public class Demo {

	public static void main(String[] args) {
		ClassA a = new ClassA();
		a.doSomething();
		a.doSomething2();

		ClassB classB = new ClassB();
		classB.doSomething();
		classB.doSomething2();
	}

}
