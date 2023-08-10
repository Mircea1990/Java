package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FilterStringArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter any words separated by space:");
		String userInput = scanner.nextLine();
		System.out.println("Please enter minimum word length to filter words:");
		int minLength = scanner.nextInt();

		String[] words = userInput.split("\\s+");
		String[] filteredWords = filterWordsByLength(minLength, words);

		System.out.println(Arrays.toString(filteredWords));

		scanner.close();
	}

	private static String[] filterWordsByLength(int minLength, String[] words) {

		return Arrays.stream(words).filter(s -> s.length() >= minLength).toArray(String[]::new);
	}

}
