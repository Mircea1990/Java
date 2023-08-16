package onlineshop.menu.impl;

import onlineshop.configs.ApplicationContext;
import onlineshop.enteties.Order;
import onlineshop.menu.Menu;
import onlineshop.services.OrderManagementService;
import onlineshop.services.impl.DefaultOrderManagementService;

public class MyOrderMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		if (context.getLoggedInUser() == null) {
			System.out.println("Please log in or create new account to see list of your orders");
			new MainMenu().start();
			return;
		} else
			printUserOrdersToConsole();

		new MainMenu().start();

	}

	private void printUserOrdersToConsole() {
		Order[] loggedInOrders = orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId());

		if (loggedInOrders == null || loggedInOrders.length == 0)
			System.out.println(
					"Unfortunately you don't have any orders yet. Place a new order before " + "visiting this option");
		else {
			for (Order order : loggedInOrders) {
				System.out.println(order);
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("****My orders****");
	}

}
