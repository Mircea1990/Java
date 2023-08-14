package solid.liskov.problem;

public class Ostrich implements Bird {

	@Override
	public void fly() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void est() {
		System.out.println("Ostrich eats");
	}

}
