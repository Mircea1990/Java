package io.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class SearchFilesByExtension {

	public static long getNumberOfFilesWithExtension(Path pathToStartSeatch, String extension) throws IOException {
		if (pathToStartSeatch == null || extension == null || extension.isEmpty()) {
			return 0;
		}
		try (Stream<Path> stream = Files.find(pathToStartSeatch, Integer.MAX_VALUE,
				(specificPath, attr) -> String.valueOf(specificPath).endsWith(extension))) {
			return stream.count();
		}
	}
}
