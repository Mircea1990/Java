package stringbuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StringBuilderDemo {

	public static void main(String[] args) {
		long timeStart = System.currentTimeMillis();
		String result = readAllFilesFromFile();
		System.out.println(result);
		long delta1 = (System.currentTimeMillis() - timeStart);

		System.out.println("=============================");

		timeStart = System.currentTimeMillis();
		result = readAllLinesFromFileWithStringBuilder();
		System.out.println(result);
		long delta2 = (System.currentTimeMillis() - timeStart);

		System.out.println("=============================");

		System.out.println("Time for operation with String: " + delta1);
		System.out.println("Time for operation with String: " + delta2);
	}

	private static String readAllLinesFromFileWithStringBuilder() {
		StringBuilder builder = new StringBuilder();
		try {
			List<String> lines = Files.readAllLines(Paths.get("./test_text.txt"));
			for (String line : lines) {
				builder.append(line).append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
		return builder.toString();
	}

	private static String readAllFilesFromFile() {
		String resultString = "";
		List<String> allLines;
		try {
			allLines = Files.readAllLines(Paths.get("./test_text.txt"));
			for (String line : allLines) {
				resultString += line;
				resultString += System.lineSeparator();
			}
		} catch (IOException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}

		return resultString;
	}

}
