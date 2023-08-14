package solid.interface_segregation.solution;

public class Motorcycle implements Drivable {

	@Override
	public void drive() {
		System.out.println("Motorcycle drives");
	}

}
