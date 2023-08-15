package onlineshop.services.impl;

import onlineshop.enteties.User;
import onlineshop.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {

	private static final String NON_UNIQUE_EMAIL_ERROR_MESSAGE = "This email us already used by another user. Please use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please try one mare try";
	private static final String NO_ERROR_MESSAGE = "";

	private static final int DEFAULT_USERS_CAPACITY = 10;

	private static DefaultUserManagementService instance;

	private DefaultUserManagementService() {
	}

	public static UserManagementService getInstance() {
		if (instance == null)
			instance = new DefaultUserManagementService();
		return instance;
	}

	@Override
	public String registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User[] getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

}
