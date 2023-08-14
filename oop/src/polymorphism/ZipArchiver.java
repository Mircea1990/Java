package polymorphism;

import java.io.File;

public class ZipArchiver implements Archiver {

	@Override
	public void arhiveFiles(File... files) {
		System.out.println("Method of ZIP Arhiver is called");
	}

	public void arhiveFiles(int maxArhiveSize, File... files) {
	}
}
