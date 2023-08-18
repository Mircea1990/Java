package lambdaandmethodreference;

public class LambdaAndMethodReferenceDemo {

	public static void main(String[] args) {

		// ========== Lambda function demo ==========
		OrderManagement management = new OrderManagement(new DefaultDistanceCalculator());

		management.setDistanceCalculator(new DistanceCalculator() {

			@Override
			public double calculateDistance(City city1, City city2) {
				return city1.getLogitude() - city2.getLogitude();
			}
		});

		DistanceCalculator calculator = (city1, city2) -> city1.getLogitude() - city2.getLogitude();
		DistanceCalculator calculator2 = (city1, city2) -> {
			System.out.println("Test inside lambda function");
			return city1.getLogitude() - city2.getLogitude();
		};

		calculator2.calculateDistance(new City(), new City());

		management.setDistanceCalculator((city1, city2) -> city1.getLatitude() - city2.getLatitude());

		// ========== Method reference demo ==========
		management.setDistanceCalculator(GoogleDistanceCalculator::getDistanceBetweenCitiesStatic);
		GoogleDistanceCalculator distanceCalculator = new GoogleDistanceCalculator();
		management.setDistanceCalculator(distanceCalculator::getDistanceBetweenCities);
	}

}

class OrderManagement {

	private DistanceCalculator distanceCalculator;

	public OrderManagement(DistanceCalculator distanceCalculator) {
		this.distanceCalculator = distanceCalculator;
	}

	public void setDistanceCalculator(DistanceCalculator distanceCalculator) {
		this.distanceCalculator = distanceCalculator;
	}
}

class DefaultDistanceCalculator implements DistanceCalculator {

	@Override
	public double calculateDistance(City city1, City city2) {
		return 0;
	}

}

class GoogleDistanceCalculator {

	public double getDistanceBetweenCities(City city1, City city2) {
		return 1;
	}

	public static double getDistanceBetweenCitiesStatic(City city1, City city2) {
		return 1;
	}
}