package onlineshop.menu.impl;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.enteties.Order;
import onlineshop.enteties.impl.DefaultOrder;
import onlineshop.menu.Menu;
import onlineshop.services.OrderManagementService;
import onlineshop.services.impl.DefaultOrderManagementService;

public class CheckoutMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {

		while (true) {

			printMenuHeader();
			Scanner scanner = new Scanner(System.in);

			String creditCardNumber = scanner.next();
			if (!createOrder(creditCardNumber)) {

				System.out.println("Thank you for purchasing from our shop. Details about your order delivery "
						+ "are send to your email");
				context.getSessionCart().clear();
				break;
			}

		}

		new MainMenu().start();
	}

	private boolean createOrder(String creditCardNum) {
		Order order = new DefaultOrder();

		if (!order.isCreditCardNumberValid(creditCardNum))
			return false;

		order.setCreditCardNumber(creditCardNum);
		order.setProducts(context.getSessionCart().getProducts());
		order.setCostumerId(context.getLoggedInUser().getId());
		orderManagementService.addOrder(order);

		return true;
	}

	@Override
	public void printMenuHeader() {
		System.out.println("****Checkout****");
		System.out.println("Enter your credit card number whithout spaces and press enter to confirm purchase");
	}

}
