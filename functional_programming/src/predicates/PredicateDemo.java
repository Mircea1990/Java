package predicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import onlineshop.enteties.Product;
import onlineshop.enteties.impl.DefaultProduct;

public class PredicateDemo {

	public static void main(String[] args) {

		System.out.println("========== Predicate demo ==========");
		List<Product> products = new ArrayList<Product>(
				Arrays.asList(new DefaultProduct(1, "Product 1", "Category 1", 37.45),
						new DefaultProduct(2, "Product 2", "Category 2", 19.71),
						new DefaultProduct(3, "Product 3", "Category 3", 27.41)));

		removeProductsIfPriceIsMoreThan(products, 28);
		for (Product product : products) {
			System.out.println(product);
		}

		System.out.println("\n========== Predicate.and() demo ==========");
		removeProductsIfPriceIsMoreThanAndCategoryIsEqualTo(products, 18, "Category 2");

		for (Product product : products) {
			System.out.println(product);
		}
	}

	private static void removeProductsIfPriceIsMoreThanAndCategoryIsEqualTo(List<? extends Product> products, int price,
			String categoryName) {
		Predicate<Product> priceIsMoreThanPredicate = product -> product.getPrice() > price;
		Predicate<Product> categoryIsEqualToPredicate = product -> product.getCategoryName().equals(categoryName);

		products.removeIf(categoryIsEqualToPredicate.and(priceIsMoreThanPredicate));
	}

	private static void removeProductsIfPriceIsMoreThan(List<? extends Product> products, int price) {
		products.removeIf(product -> product.getPrice() > price);
	}

}
