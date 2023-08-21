package io.exercise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/*Implement console application that meets following requirements:

	Implement console text editor

	Program asks user to input text

	Program writes all user input to file

	When user writes ‘exit’ - program stops execution
	
	When program is finished - content of the file is written to console*/

public class ConsoleTextEditor {

	private static final String EXIT_TEXT = "exit";
	private File fileToWrite;

	public ConsoleTextEditor(File fileToWrite) {
		this.fileToWrite = fileToWrite;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);
		StringBuilder builder = new StringBuilder();
		while (true) {
			System.out.println("Please input a text to be wrriten into file and then type 'exit' ");
			String inputText = scanner.nextLine();
			if (inputText.equalsIgnoreCase(EXIT_TEXT)) {
				saveTextToFile(builder);
				return;
			}
			builder.append(inputText).append(System.lineSeparator());
		}

	}

	private void saveTextToFile(StringBuilder builder) {
		try {
			Files.write(fileToWrite.toPath(), builder.toString().getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
