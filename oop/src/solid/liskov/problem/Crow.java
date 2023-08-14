package solid.liskov.problem;

public class Crow implements Bird {

	@Override
	public void fly() {
		System.out.println("Crow flies");
	}

	@Override
	public void est() {
		System.out.println("Crow eats");
	}

}
