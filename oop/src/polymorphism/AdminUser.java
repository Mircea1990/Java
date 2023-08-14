package polymorphism;

public class AdminUser extends User implements Profile {

	private String userGroup = "Admin";

	@Override
	public void validateAccesRights() {
		System.out.println("I'm an admin user. I can do what I  want in the system");
	}

	@Override
	public AccountInformation getProfileInformation(Profile profile) {
		userGroup = "default";
		System.out.println("Getting informations...");
		profile = new UserProfile();
		return new AccountInformation();
	}

}
