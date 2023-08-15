package onlineshop.menu.impl;

import onlineshop.configs.ApplicationContext;
import onlineshop.menu.Menu;

public class MainMenu implements Menu {

	private static final String MENU_COMMAND = "menu";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please enter number in console to proceed."
			+ System.lineSeparator() + "1. Sign up" + System.lineSeparator() + "2. Sign in" + System.lineSeparator()
			+ "3. Product catalog" + System.lineSeparator() + "4. My orders" + System.lineSeparator() + "5. Settings"
			+ System.lineSeparator() + "6. Customer list";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please enter number in console to proceed."
			+ System.lineSeparator() + "1. Sign up" + System.lineSeparator() + "2. Sign out" + System.lineSeparator()
			+ "3. Product catalog" + System.lineSeparator() + "4. My orders" + System.lineSeparator() + "5. Settings"
			+ System.lineSeparator() + "6. Customer list";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		System.out.println("Welcome to online shop!");
		printMenuHeader();

	}

	@Override
	public void printMenuHeader() {
		System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);

	}

}
