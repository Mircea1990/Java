package core;

public class StringFormattingDemo {

	public static void main(String[] args) {
		System.out.println("===== String formatting =====");
		System.out.println();

		String fName = "Mircea";

		String greetingsTemplate = "Hello, dear %s! Good %s !";
		String morning = "morning";
		String afternoon = "afternoon";
		String evening = "evening";

		// String formattedString = String.format(greetingsTemplate, fName, morning);
		String formattedString = String.format(greetingsTemplate, fName, evening);

		System.out.println(formattedString);

		System.out.printf("You still have %d computers in store\n", 10);
	}

}
