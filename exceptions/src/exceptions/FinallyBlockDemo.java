package exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FinallyBlockDemo {

	public static void main(String[] args) {
		try {
			Files.readAllLines(Paths.get("path to not existing file.txt"));
		} catch (IOException e) {
			System.out.println("In the cach block");
			System.out.println("Stack trace: " + e.getStackTrace());
		} finally {
			System.out.println("In the finally block ");
		}

	}

}
