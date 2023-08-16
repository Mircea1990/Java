package onlineshop.menu.impl;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.menu.Menu;

public class ChangePasswordMenu implements Menu {

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.next();
		context.getLoggedInUser().setPassword(userInput);
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("****Change Password****");
		System.out.println("Enter new password: ");
	}

}
