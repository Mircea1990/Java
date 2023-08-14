package solid.interface_segregation.solution;

public class Plane implements Drivable, Flyable {

	@Override
	public void fly() {
		System.out.println("Plane flies");
	}

	@Override
	public void drive() {
		System.out.println("Plane drives");
	}

}
