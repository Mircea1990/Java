package solid.dependency_inversion.solution;

public class AccuweatherApi implements WeatherSource {

	@Override
	public double getTemperatureCelcius() {
		return 30;
	}

}
