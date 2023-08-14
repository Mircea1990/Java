package inheritance;

public class ObjectInitializationOrder {

	public static void main(String[] args) {

		Parent parent1 = new Parent();
		System.out.println("-----------");

		Parent parent2 = new Child();
		System.out.println("-----------");

		parent2 = new Child();

	}

}

class Parent {

	static {
		System.out.println("1. Static init block parent");
	}

	{
		System.out.println("3. Init block parent");
	}

	public Parent() {
		System.out.println("4. Parent contructor");
	}
}

class Child extends Parent {

	static {
		System.out.println("2. Static init block child");
	}

	{
		System.out.println("5. Init block child");
	}

	public Child() {
		System.out.println("6. Child constructor");
	}
}