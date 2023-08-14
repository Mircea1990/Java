package solid.dependency_inversion.solution;

public class BbcWeatherApi implements WeatherSource {

	@Override
	public double getTemperatureCelcius() {
		return toCelcius(getTemperatureFahrenheit());
	}

	private double getTemperatureFahrenheit() {
		return 0;
	}

	private double toCelcius(double temperatureFahrenheit) {
		return (temperatureFahrenheit - 32) / 1.8f;
	}
}
