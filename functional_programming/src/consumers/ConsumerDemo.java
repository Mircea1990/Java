package consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import onlineshop.enteties.Product;
import onlineshop.enteties.impl.DefaultProduct;

public class ConsumerDemo {

	public static void main(String[] args) {
		System.out.println("========== Consumer demo ==========");
		List<Product> products = new ArrayList<Product>(
				Arrays.asList(new DefaultProduct(1, "Product 1", "Category 1", 99.99),
						new DefaultProduct(2, "Product 2", "Category 2", 75.15),
						new DefaultProduct(3, "Product 3", "Category 3", 78.26)));
		increasePriceForProductList(products, 10);

		for (Product product : products) {
			System.out.println(product);
		}

		System.out.println("========== BiConsumer demo ==========");
		Map<Integer, Product> productsMap = new HashMap<Integer, Product>();
		productsMap.put(1, new DefaultProduct(1, "Product 1", "Category 1", 99.99));
		productsMap.put(2, new DefaultProduct(2, "Product 2", "Category 2", 71.65));
		productsMap.put(3, new DefaultProduct(3, "Product 2", "Category 3", 75.10));

		increasePriceForProductMap(productsMap, 15);
		for (Product product : productsMap.values()) {
			System.out.println(product);
		}
	}

	private static void increasePriceForProductMap(Map<Integer, ? extends Product> productsMap, int priceToIncrease) {
		productsMap.forEach((id, product) -> product.setPrice(product.getPrice() + priceToIncrease));
	}

	private static void increasePriceForProductList(List<? extends Product> products, int priceToIncrease) {
		products.iterator().forEachRemaining(product -> product.setPrice(product.getPrice() + priceToIncrease));
	}

}
