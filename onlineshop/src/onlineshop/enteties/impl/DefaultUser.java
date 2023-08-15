package onlineshop.enteties.impl;

import onlineshop.enteties.User;

public class DefaultUser implements User {

	private String firstName;
	private String lastName;
	private String password;
	private String email;

	public DefaultUser() {
	}

	public DefaultUser(String firstName, String lastName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPassword(String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEmail(String newEmail) {
		// TODO Auto-generated method stub

	}

	void clearState() {

	}

	@Override
	public String toString() {
		return "DefaultUser [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", email="
				+ email + "]";
	}

}
