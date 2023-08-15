package onlineshop;

import onlineshop.menu.Menu;
import onlineshop.menu.impl.MainMenu;

public class Main {

	public static void main(String[] args) {

		Menu main = new MainMenu();
		main.start();
	}
}
