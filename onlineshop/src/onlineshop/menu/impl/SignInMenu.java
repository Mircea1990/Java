package onlineshop.menu.impl;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.enteties.User;
import onlineshop.menu.Menu;
import onlineshop.services.UserManagementService;
import onlineshop.services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please, enter your email: ");
		String userEmail = scanner.next();

		System.out.println("Please, enter your password: ");
		String userPassword = scanner.next();

		User user = userManagementService.getUserByEmail(userEmail);

		if (user != null && user.getPassword().equals(userPassword)) {
			System.out.printf("Glad to see you back %s %s", user.getFirstName(), user.getLastName());
			context.setLoggedInUser(user);
		} else {
			System.out.println("Unfortunately, such login and password doesn't exist");
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("****Sign in****");
	}

}
