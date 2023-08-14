package solid.liskov.problem;

public class Sparrow implements Bird {

	@Override
	public void fly() {
		System.out.println("Sparrow flies");
	}

	@Override
	public void est() {
		System.out.println("Sparrow eats");
	}

}
