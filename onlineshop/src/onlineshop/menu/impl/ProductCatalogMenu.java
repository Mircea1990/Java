package onlineshop.menu.impl;

import java.util.Scanner;

import onlineshop.configs.ApplicationContext;
import onlineshop.enteties.Cart;
import onlineshop.enteties.Product;
import onlineshop.menu.Menu;
import onlineshop.services.ProductManagementService;
import onlineshop.services.impl.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu {

	private static final String CHECKOUT_COMMAND = "checkout";

	private ApplicationContext context;
	private ProductManagementService productManagementService;

	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	}

	@Override
	public void start() {
		Menu menuToNavigate = null;

		while (true) {
			printMenuHeader();
			printProductsToConsole();

			String userInput = readUserInput();

			if (context.getLoggedInUser() == null) {
				menuToNavigate = new MainMenu();
				System.out.println("You are not logged it. Please sign in or create a new accout");
				break;
			}

			if (userInput.equalsIgnoreCase(MainMenu.getMenuCommand())) {
				menuToNavigate = new MainMenu();
				break;
			}
			if (userInput.equalsIgnoreCase(CHECKOUT_COMMAND)) {

				Cart sessionCart = context.getSessionCart();
				if (sessionCart == null || sessionCart.isEmpty())
					System.out.println(
							"Your cart is empty. Please add product" + " to cart first and then proceed with checkout");
				else {
					menuToNavigate = new CheckoutMenu();
					break;
				}
			} else {
				Product productToAddToCart = fetchProduct(userInput);

				if (productToAddToCart == null) {
					System.out.println("Please enter product ID if you want to add product to cart. "
							+ System.lineSeparator() + "You can type 'checkout' if you want to proceed with checkout."
							+ System.lineSeparator()
							+ "You can type 'menu' if you want to navigate back to the main menu.");
					continue;
				}
				processAddToCart(productToAddToCart);
			}
		}
		menuToNavigate.start();
	}

	private String readUserInput() {
		System.out.println("Enter a product ID to add it to cart or enter 'checkout' to proceed with checkout: ");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.next();
		return userInput;
	}

	private void processAddToCart(Product productToAddToCart) {
		context.getSessionCart().addProduct(productToAddToCart);
		System.out.printf(
				"Product %s has been added to your cart. " + System.lineSeparator()
						+ "If you want to add a new product - enter the product id. " + System.lineSeparator()
						+ "If you want to proceed with checkout - enter word " + "'checkout' to console %n",
				productToAddToCart.getProductName() + "\n");

	}

	private Product fetchProduct(String userInput) {
		int productIdToAddToCart = Integer.parseInt(userInput);
		Product productToAddToCart = productManagementService.getProductById(productIdToAddToCart);
		return productToAddToCart;
	}

	private void printProductsToConsole() {
		Product[] products = productManagementService.getProducts();
		for (Product product : products) {
			System.out.println(" " + product);
		}

	}

	@Override
	public void printMenuHeader() {
		System.out.println("****Shop product catalog****");
		System.out.println("Enter product id to add it to the cart or "
				+ "type 'menu' if you want to navigate back to the main page");
	}

}
