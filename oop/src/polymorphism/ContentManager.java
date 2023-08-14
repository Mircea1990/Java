package polymorphism;

public class ContentManager extends User {

	@Override
	public void validateAccesRights() {
		System.out.println("I'm a content manager. I have not enought rights to withdraw money.");
	}

	@Override
	public ProfileInformationData getProfileInformation(Profile profile) {
		return new AccountInformation();
	}

}
