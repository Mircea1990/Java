package datastructures;

public class ElectricCar implements Vehicle {

	@Override
	public void drive() {
		System.out.println("Electric car drives");

	}

	@Override
	public void startEngine() {
		System.out.println("Electric car started its engine");
	}

}
