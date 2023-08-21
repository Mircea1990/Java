package io.exercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestIO {

	public static void main(String[] args) throws IOException {
		String dbFilePath = "DBConfig.txt";
		String dbConfigText = "spring.jpa.hibernate.ddl-auto=none\r\n"
				+ "spring.datasource.url=jdbc:mysql://localhost:3306/todo_example\r\n"
				+ "spring.datasource.username=todouser\r\n" + "spring.datasource.password=YOUR_PASSWORD";

		// write to db file
		try (var gfw = new BufferedWriter(new FileWriter(dbFilePath))) {
			gfw.write(dbConfigText);
		}

		Path path = Paths.get("D:\\Mircea\\Udemy\\Java\\io");
		long numberOfFiles = SearchFilesByExtension.getNumberOfFilesWithExtension(path, ".java");

		System.out.println("Number of java files: " + numberOfFiles);

		System.out.println("----------DB config file----------");
		Path pathForDB = Paths.get("D:\\Mircea\\Udemy\\Java\\io\\DBConfig.txt");
		String congifFromDB = DBConfigMap.getValueFromConfigMap(pathForDB, "spring.datasource.password");

		System.out.println("Config value from DB file: " + congifFromDB);

		// console text editor
		System.out.println("----------Console text editor----------");
		File file = new File("D:\\Mircea\\Udemy\\Java\\io\\src\\io\\exercise\\consoleFile.txt");
		file.createNewFile();
		ConsoleTextEditor editor = new ConsoleTextEditor(file);
		editor.start();
	}

}
