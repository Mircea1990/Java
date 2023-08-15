package exceptions;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CheckedExceptionDemo {

	public static void main(String[] args) {
		//Files.readAllLines(Paths.get("path to non existing file.txt")); // Unhandled exception type IOException
	}

}
