package polymorphism;

public abstract class User {

	private int id;
	private String name;

	public void validateAccesRights() {
		System.out.println("I'm an abstract user. I don't have specific rights.");
	}

	public abstract ProfileInformationData getProfileInformation(Profile profile);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
