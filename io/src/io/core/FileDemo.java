package io.core;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("testDirectory");
		file.mkdir();

		file = new File("testDirectory2\\innerTestDirectory");
		file.mkdir();

		file = new File("testDirectory3" + File.separator + "innerTestDirectory");
		if (file.mkdir())
			System.out.println("Succes!");
		else
			System.out.println("File already exists");

		System.out.println("File separator: " + File.separator);
		System.out.println("Path separator: " + File.pathSeparator);

		String toWrite = "asdasdasd" + System.lineSeparator() + "new line";
		System.out.println("toWrite: " + toWrite);

		file = new File("result.csv");
		file.createNewFile();

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			System.out.println("Array of file: " + Arrays.toString(files));
		}
		file.getAbsoluteFile();
		file.canExecute();

		file.isFile();

		file.isHidden();

		File[] listFiles = file.listFiles(path -> path.getName().endsWith(".java"));

		System.out.println(Arrays.toString(listFiles));

		new File("D:\\Mircea\\Udemy\\Java\\io\\testFile");
	}
}
