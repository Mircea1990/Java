package encapsulation.package2;

public class ClassC extends ClassB {

	@Override
	void doSomethingClassB() {
		super.doSomethingClassB();
		System.out.println("doSomethingClassB in pachage2 - ClassC");
	}

}
