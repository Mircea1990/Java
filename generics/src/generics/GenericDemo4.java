package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo4 {

	public static void main(String[] args) {

		List<Child> children = new ArrayList<Child>();
		children.add(new Child());

		processElements(children);

		Child child = children.get(0);
		child.childMethod();

		List<Parent> parents = new ArrayList<Parent>();
		List<Child> children2 = new ArrayList<Child>();

		processElements2(parents);
		processElements2(children2);

		List<GrandChild> grandChilds = new ArrayList<GrandChild>();

		Child child2 = children.get(0);
		child.childMethod();
	}

	private static void processElements2(List<? super Child> elements) {

		elements.add(new Child());
		elements.add(new GrandChild());
		elements.add(null);
	}

	private static void processElements(List<? extends Parent> elements) {
		Parent parent = elements.get(0);

		elements.add(null);
	}

}

class Parent {

}

class Child extends Parent {
	public void childMethod() {
		System.out.println("Child method");
	}
}

class GrandChild extends Child {

}