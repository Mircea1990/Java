package io.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOStreamsDemo {

	public static void main(String[] args) throws IOException {
		String filePath = "testDirectory" + File.separator + "demo.txt";
		String textToWrite = "Some text example" + System.lineSeparator() + "with Line separator and latin text: "
				+ System.lineSeparator() + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ System.lineSeparator() + "Cras libero quam, gravida non viverra eu, consectetur at diam. "
				+ System.lineSeparator() + "Donec scelerisque, turpis a gravida iaculis, orci velit tempor "
				+ System.lineSeparator() + "turpis, at fermentum justo augue at dui. Morbi nec ante ut leo suscipit "
				+ System.lineSeparator()
				+ "pellentesque. Suspendisse neque risus, luctus quis pulvinar eu, iaculis id lectus. "
				+ System.lineSeparator() + "Mauris rhoncus, mi eu vulputate aliquet, justo ligula tincidunt magna, "
				+ System.lineSeparator() + "ac hendrerit felis magna ut lorem. Nunc dui diam, sodales vel nisl vel, "
				+ System.lineSeparator()
				+ "pellentesque euismod dolor. Mauris finibus vehicula odio, ac facilisis velit imperdiet a. "
				+ System.lineSeparator() + "Aliquam bibendum urna id augue varius, ac venenatis nibh ultricies. "
				+ System.lineSeparator()
				+ "Sed tincidunt dui quis vestibulum mattis. Ut maximus, risus in mattis consectetur, "
				+ System.lineSeparator()
				+ "velit ante auctor erat, vel eleifend lorem odio sed massa. Nam consectetur odio lacus, "
				+ System.lineSeparator() + "et sollicitudin eros molestie sed. Sed a tempor risus, ut ornare orci. "
				+ System.lineSeparator()
				+ "Vestibulum sed tincidunt nisi. Donec quam nunc, viverra at convallis in, sodales at erat. "
				+ System.lineSeparator() + "Nullam mattis risus eget laoreet tempor." + System.lineSeparator();

		// ===== Write examples
		writeFileToPathFileOutputStream(filePath, textToWrite);
		writeFileToPathOutputStreamWithBuffer(filePath, textToWrite);
		noWriteWithoutFlush(filePath, textToWrite);
		writeFileToPathWriter(filePath, textToWrite);
		writeFileToPathFileWriterBuffered(filePath, textToWrite);

		// ===== Read examples
		printFileWithFileInputStream(filePath);
		System.out.println("-----------");
		printFileWithFileInputStreamWithBuffer(filePath);
		System.out.println("-----------");
		printFileWithFileReader(filePath);
		System.out.println("-----------");
		printFileWithBuffer(filePath);
		System.out.println("-----------");

		// ===== NIO write example
		writeNio(filePath, textToWrite);

		// ===== NIO read examples
		printFileToConsole(filePath);
		System.out.println("-----------");
		printFileToConsoleWithCustomEncoding(filePath);
		System.out.println("-----------");

		// ===== NIO misc demo
		findMethodDemo("D:\\Mircea\\Udemy\\Java\\io\\src\\io\\core", 4);
		System.out.println("-----------");
		walkMethodDemo("D:\\Mircea\\Udemy\\Java");
	}

	private static void walkMethodDemo(String filePath) throws IOException {
		Files.walk(Paths.get(filePath)).filter(p -> p.toString().endsWith(".settings"))
				.map(p -> p.getParent().getParent()).distinct().forEach(System.out::println);

	}

	private static void findMethodDemo(String filePath, int maxDepth) throws IOException {
		Path start = Paths.get(filePath);
		try (Stream<Path> stream = Files.find(start, maxDepth,
				(specificPath, attr) -> String.valueOf(specificPath).endsWith(".java"))) {
			String joined = stream.sorted().map(String::valueOf).collect(Collectors.joining(";"));
			if (joined != null && !joined.isEmpty()) {
				System.out.println("Found: " + joined);
			}
		}

	}

	private static void printFileToConsoleWithCustomEncoding(String filePath) throws IOException {
		try (Stream<String> stream = Files.lines(Paths.get(filePath), Charset.forName("UTF8"))) {
			SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
			stream.forEach(System.out::println);
		}

	}

	private static void printFileToConsole(String filePath) throws IOException {
		try (Stream<String> fStream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			fStream.forEach(System.out::println);
		}
		List<String> readAllLines = Files.readAllLines(Paths.get(filePath));
	}

	private static void writeNio(String filePath, String textToWrite) throws IOException {
		Files.write(Paths.get(filePath), textToWrite.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		List<String> lines = Arrays.asList("a", "b", "d");
		Files.write(Paths.get(filePath), lines, StandardCharsets.UTF_8);
	}

	private static void printFileWithBuffer(String filePath) throws FileNotFoundException, IOException {
		try (var br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}

	}

	private static void printFileWithFileReader(String filePath) throws IOException {
		try (var fr = new FileReader(filePath)) {
			int content;
			while ((content = fr.read()) != -1) {
				System.out.print((char) content);
			}
		}

	}

	private static void printFileWithFileInputStreamWithBuffer(String filePath)
			throws FileNotFoundException, IOException {
		try (var fis = new FileInputStream(filePath);
				var bis = new BufferedInputStream(fis);
				var dis = new DataInputStream(bis);) {
			int i;
			while (dis.available() != 0) {
				System.out.print(dis.readLine());
				System.out.println();
			}
		}

	}

	private static void printFileWithFileInputStream(String filePath) throws FileNotFoundException, IOException {
		try (var fis = new FileInputStream(filePath)) {
			int i;
			while ((i = fis.read()) != -1) {
				System.out.print((char) i);
			}
		}

	}

	private static void writeFileToPathFileWriterBuffered(String filePath, String textToWrite) throws IOException {
		try (var gfw = new BufferedWriter(new FileWriter(filePath))) {
			gfw.write(textToWrite);
		}

	}

	private static void writeFileToPathWriter(String filePath, String textToWrite) throws IOException {
		try (var fw = new FileWriter(filePath)) {
			fw.write(filePath);
		}

	}

	private static void noWriteWithoutFlush(String filePath, String textToWrite) throws IOException {
		var bos = new BufferedOutputStream(new FileOutputStream(filePath));
		bos.write(filePath.getBytes());
		// bos.flush();
	}

	private static void writeFileToPathOutputStreamWithBuffer(String filePath, String textToWrite)
			throws FileNotFoundException, IOException {
		try (var fbos = new BufferedOutputStream(new FileOutputStream(filePath))) {
			fbos.write(textToWrite.getBytes());
		}

	}

	private static void writeFileToPathFileOutputStream(String filePath, String textToWrite) throws IOException {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			byte[] bs = textToWrite.getBytes();
			fos.write(bs);
		} finally {
			if (fos != null)
				fos.close();
		}
	}

}
