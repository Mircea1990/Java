import java.util.Arrays;
import java.util.Scanner;

public class SortWordsInArray {

	public static void main(String[] args) {
		System.out.println("Please enter words separated by space:");
		Scanner scanner = new Scanner(System.in);

		String userInput = scanner.nextLine();
		String[] words = userInput.split("\\s+");

		Arrays.sort(words, (s1, s2) -> {
			int result = s2.length() - s1.length();
			if (result == 0)
				result = s1.compareToIgnoreCase(s2);
			return result;
		});
		for (String word : words) {
			System.out.println(word + " ");
		}
		scanner.close();
	}

}
