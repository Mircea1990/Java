package exercise;

public class StringProcessor {

	public static final String INPUT_DATA = "Login;Name;Email" + System.lineSeparator()
			+ "mircea; Stefanescu Mircea;mircea@gmail.com" + System.lineSeparator()
			+ "gigel; Vasilescu Gigel;gigel@yahoo.com" + System.lineSeparator()
			+ "ionica; Constantin Ionica;ionica@gmail.com" + System.lineSeparator()
			+ "marcel; Iliescu Marcel;marcel@outlook.com";

	public static void main(String[] args) {
		System.out.println("===== Convert 1 demo =====");
		System.out.println(convert1(INPUT_DATA));

		System.out.println("===== Convert 2 demo =====");
		System.out.println(convert2(INPUT_DATA));
	}

	private static String convert2(String inputData) {
		String result = new String();
		String[] lines = inputData.split(System.lineSeparator());
		for (int i = 0; i < lines.length; i++) {
			String[] wordsInLine = lines[i].split(";");
			result += wordsInLine[1] + " (email: " + wordsInLine[2] + ")" + System.lineSeparator();
		}
		return result;
	}

	private static String convert1(String inputData) {
		String result = "";
		String[] lines = inputData.split(System.lineSeparator());
		for (int i = 1; i < lines.length; i++) {
			String[] wordsInLine = lines[i].split(";");
			result += wordsInLine[0] + " ==> " + wordsInLine[2] + System.lineSeparator();
		}
		return result;
	}

}
