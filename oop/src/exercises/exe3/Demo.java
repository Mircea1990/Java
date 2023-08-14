package exercises.exe3;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		Sweet candy = new ChocolateCandy();
		candy.setName("Candy good");
		candy.setSugarWeight(0.75);
		candy.setWeight(0.5);

		Cookie cookie = new Oreo();
		cookie.setName("Oreo max");
		cookie.setSugarWeight(0.12);
		cookie.setWeight(6.4);
		cookie.setDoughWeight(7.1);

		Sweet lollipop = new Lollopop();
		lollipop.setWeight(.9);
		lollipop.setSugarWeight(0.8);
		lollipop.setName("Lollipop best");

		Present present = new Present();
		present.addSweet(candy);
		present.addSweet(cookie);
		present.addSweet(lollipop);

		System.out.println("Present: " + Arrays.toString(present.getSweets()));

		Sweet[] sweetsFiltered = present.filterSweetsBySugarRange(0, 0.7);
		System.out.println("Filtered sweets: " + Arrays.toString(sweetsFiltered));

		System.out.println("Total weight of the present: " + present.calculateTotalWeight());
	}

}
