package exercises.exe3;

import java.util.Arrays;
import java.util.Objects;

public class Present {

	private static final int DEFAULT_GIFT_CAPACITY = 10;
	private Sweet[] sweets;
	private int lastIndexAdded;

	{
		sweets = new Sweet[DEFAULT_GIFT_CAPACITY];
	}

	// the method filters sweets by sugar weight inclusively
	public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight) {
		return Arrays.stream(sweets).filter(Objects::nonNull).filter(sweet -> {
			if (sweet.getSugarWeight() >= minSugarWeight && sweet.getSugarWeight() <= maxSugarWeight)
				return true;
			else
				return false;
		}).toArray(Sweet[]::new);
	}

	// the method calculates total weight of the present
	public double calculateTotalWeight() {
		return Arrays.stream(sweets).filter(Objects::nonNull).mapToDouble(sweet -> sweet.getWeight()).sum();
	}

	// the method that adds sweet to the present
	public void addSweet(Sweet sweet) {
		if (sweet == null)
			return;
		if (sweets.length <= lastIndexAdded)
			sweets = Arrays.copyOf(sweets, sweets.length * 2);
		sweets[lastIndexAdded++] = sweet;
	}

	public Sweet[] getSweets() {
		return Arrays.stream(sweets).filter(Objects::nonNull).toArray(Sweet[]::new);
	}
}
