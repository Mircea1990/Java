package polymorphism;

import java.io.File;

public class RarArchiver implements Archiver {

	@Override
	public void arhiveFiles(File... files) {
		System.out.println("Method of RAR Arhiver is called");

	}

}
