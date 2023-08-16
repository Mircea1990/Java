package onlineshop.menu.impl;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.enteties.User;
import onlineshop.enteties.impl.DefaultUser;
import onlineshop.menu.Menu;
import onlineshop.services.UserManagementService;
import onlineshop.services.impl.DefaultUserManagementService;

public class SignUpMenu implements Menu {

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
		System.out.println("Please, enter your first name: ");
		String firstName = scanner.next();
		System.out.println("Please, enter your last name: ");
		String lastName = scanner.next();
		System.out.println("Please, enter your password: ");
		String password = scanner.next();
		System.out.println("Please, enter your email: ");
		String email = scanner.next();

		User user = new DefaultUser(firstName, lastName, password, email);

		String errorMessage = userManagementService.registerUser(user);
		if (errorMessage == null || errorMessage.isEmpty()) {
			context.setLoggedInUser(user);
			System.out.println("New user is created");
		} else {
			System.out.println(errorMessage);
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("****Sign up****");
	}

}
