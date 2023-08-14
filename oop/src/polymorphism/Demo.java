package polymorphism;

import java.io.File;

public class Demo {

	public static void main(String[] args) {
		User contentManager = new ContentManager();
		contentManager.validateAccesRights();

		User admin = new AdminUser();
		admin.validateAccesRights();
		// admin.getProfileInformation(new AdminUser());

		System.out.println("\n");

		Archiver zipArhiver = new ZipArchiver();
		zipArhiver.arhiveFiles(new File(""));

		Archiver rarArhiver = new RarArchiver();
		rarArhiver.arhiveFiles(new File(""));

		System.out.println("\n");
		contentManager.getProfileInformation(new UserProfile());
	}

}
