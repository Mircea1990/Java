package exceptions;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MultipleCatchBlocks {

	public static void main(String[] args) {
		try {
			Files.readAllLines(Paths.get("Path to not existing file.txt"));
			Connection connection = DriverManager.getConnection("");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		try {
			Files.readAllLines(Paths.get("Path to not existing file.txt"));
			Connection connection = DriverManager.getConnection("");
		} catch (IOException e) {
			System.out.println("Notify user that file doesn't exist and ask user to provide new file");
		} catch (SQLException e) {
			System.out.println("Notify user that there is some error with database");
		}

		try {
			Files.readAllLines(Paths.get("Path to not existing file.txt"));
			var fr = new FileReader("fileName.txt");
		} catch (IOException e) {
			System.out.println("Notify user that file doesn't exist and ask user to provide new file");
		}
	}
}
