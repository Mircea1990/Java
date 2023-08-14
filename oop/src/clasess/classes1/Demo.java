package clasess.classes1;

import java.math.BigDecimal;

public class Demo {

	public static void main(String[] args) {
		System.out.println("========== DEFAULT CONSTRUCTOR DEMO ==========");

		Cart cart = new Cart();
		System.out.println(cart);

		System.out.println();
		System.out.println("========== CUSTOM CONSTRUCTOR DEMO ==========");
		Cart cart2 = new Cart(5, 7);
		System.out.println(cart2);

		System.out.println();
		System.out.println("========== ADD PRODUCTS TO CART ==========");
		cart.addProduct(new Product("Product 1", BigDecimal.valueOf(750)));
		cart.addProduct(new Product("Product 2", BigDecimal.valueOf(250)));
		System.out.println(cart);
	}

}
