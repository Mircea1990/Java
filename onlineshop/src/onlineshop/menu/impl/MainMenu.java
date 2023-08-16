package onlineshop.menu.impl;

import java.util.Scanner;

import main.Main;
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

		if (context.getMainMenu() == null)
			context.setMainMenu(this);

		Menu menuToNavigate = null;
		mainLoop: while (true) {
			printMenuHeader();

			Scanner scanner = new Scanner(System.in);

			System.out.println("\nChoose one of the above options: ");
			String userOption = scanner.next();

			if (!inputIsCharacter(userOption)) {
				System.out.println("\nOnly digits are allowed ! \nPlease try again\n");
				continue;
			}

			if (userOption.equalsIgnoreCase(Main.EXIT_COMMAND)) {
				System.out.println("\nHave a nice day!");
				System.exit(0);

			} else {
				int optionNumber = Integer.parseInt(userOption);
				switch (optionNumber) {
				case 1:
					menuToNavigate = new SignUpMenu();
					break mainLoop;
				case 2:
					if (context.getLoggedInUser() == null)
						menuToNavigate = new SignInMenu();
					else
						menuToNavigate = new SignOutMenu();
					break mainLoop;
				case 3:
					menuToNavigate = new ProductCatalogMenu();
					break mainLoop;
				case 4:
					menuToNavigate = new MyOrderMenu();
					break mainLoop;
				case 5:
					menuToNavigate = new SettingsMenu();
					break mainLoop;
				case 6:
					menuToNavigate = new CustomerListMenu();
					break mainLoop;
				default:
					System.out.println("\nOnly 1,2,3,4,5 or 6 is allowed. Please try one more time\n");
					continue;
				}
			}

		}
		menuToNavigate.start();
	}

	private boolean inputIsCharacter(String userOption) {
		for (int i = 0; i < userOption.length(); i++)
			if (Character.isDigit(userOption.charAt(i)) == false)
				return false;
		return true;
	}

	@Override
	public void printMenuHeader() {
		System.out.println("****Main Menu****");
		if (context.getLoggedInUser() == null)
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
		else
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
	}

	public static String getMenuCommand() {
		return MENU_COMMAND;
	}

}
