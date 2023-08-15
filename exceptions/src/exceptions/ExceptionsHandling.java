package exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ExceptionsHandling {

	public static void main(String[] args) {

		try {
			Files.readAllLines(Paths.get("path to non existing file.txt"));
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("In the catch block");
			System.out.println("Logging stack trace: " + Arrays.toString(e.getStackTrace()));
			System.out.println("Cause: " + e.getCause());
			System.out.println("Message: " + e.getMessage());
		}
	}

}
