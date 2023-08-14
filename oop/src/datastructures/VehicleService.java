package datastructures;

public class VehicleService {

	public void moveVehicle(Vehicle vehicle) {
		if (vehicle instanceof ElectricCar)
			System.out.println("Get electric car components");
		if (vehicle instanceof PetrolCar)
			System.out.println("Get petrol car components");
		if (vehicle instanceof Motorcycle)
			System.out.println("Get motorcycle components");
	}

	public void startVehicleEngine(Vehicle vehicle) {
		if (vehicle instanceof ElectricCar)
			System.out.println("Start electric car engine");
		if (vehicle instanceof PetrolCar)
			System.out.println("Start petrol car engine");
		if (vehicle instanceof Motorcycle)
			System.out.println("Start motorcycle engine");
	}
}
