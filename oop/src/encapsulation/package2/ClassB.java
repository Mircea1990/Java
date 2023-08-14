package encapsulation.package2;

import encapsulation.package1.ClassA;

public class ClassB extends ClassA {

	void doSomethingClassB() {
		doSomething2();
		doSomethingClassBPrivate();
	}

	private void doSomethingClassBPrivate() {
		System.out.println("doSomethingClassBPrivate() in pachage2 - ClassB");
	}
}
