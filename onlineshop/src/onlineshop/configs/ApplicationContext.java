package onlineshop.configs;

import onlineshop.enteties.Cart;
import onlineshop.enteties.User;
import onlineshop.enteties.impl.DefaultCard;
import onlineshop.menu.Menu;

public class ApplicationContext {

	private static ApplicationContext instace;

	private User loggedInUser;
	private Menu mainMenu;
	private Cart sessionCart;

	private ApplicationContext() {
	}

	public void setLoggedInUser(User user) {
		if (this.sessionCart != null)
			this.sessionCart.clear(); // session cart is cleared when new user is logged in
		this.loggedInUser = user;
	}

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public Menu getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(Menu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public Cart getSessionCart() {
		if (this.sessionCart == null)
			this.sessionCart = new DefaultCard();
		return sessionCart;
	}

	public static ApplicationContext getInstance() {
		if (instace == null)
			instace = new ApplicationContext();
		return instace;
	}
}
