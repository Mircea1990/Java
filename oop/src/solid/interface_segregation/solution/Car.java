package solid.interface_segregation.solution;

public class Car implements Drivable {

	@Override
	public void drive() {
		System.out.println("Car drives");
	}

}
