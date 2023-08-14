package datastructures;

public class Demo {

	public static void main(String[] args) {

		Motorcycle motorcycle = new Motorcycle();
		motorcycle.drive();
		System.out.println(motorcycle);

		VehicleService service = new VehicleService();
		service.startVehicleEngine(new ElectricCar());
		System.out.println(service);

		service.moveVehicle(new Motorcycle());
		System.out.println(service);

	}
}
