package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import onlineshop.enteties.Product;
import onlineshop.enteties.impl.ComparableProduct;
import onlineshop.services.impl.DefaultProductManagementService;

public class ComparisonDemo {

	public static void main(String[] args) {

		List<Integer> integers = new ArrayList<Integer>(Arrays.asList(1, 8, 4, -7, 152, 34));
		System.out.print("Integers: " + integers);

		System.out.println();
		System.out.print("Sorted order: ");
		integers.sort(Comparator.naturalOrder());
		System.out.println(integers);

		integers.sort(Comparator.reverseOrder());
		System.out.print("Reverse order: " + integers);
		System.out.println("\n");

		System.out.println("---Products---");
		List<Product> products = Arrays.asList(DefaultProductManagementService.getInstance().getProducts());
		printProductsInNewLine(products);

		System.out.println("\nSorting products");
		ComparableProduct comparableProduct1 = new ComparableProduct(1, "Product 1", "Category 1", 100);
		ComparableProduct comparableProduct2 = new ComparableProduct(2, "Product 2", "Category 2", 200);
		ComparableProduct comparableProduct3 = new ComparableProduct(3, "Product 3", "Category 3", 300);
		ComparableProduct comparableProduct4 = new ComparableProduct(4, "Product 4", "Category 4", 400);

		List<ComparableProduct> comparableProducts = new ArrayList<ComparableProduct>(
				Arrays.asList(comparableProduct1, comparableProduct2, comparableProduct3, comparableProduct4));
		comparableProducts.sort(Comparator.naturalOrder());
		System.out.println("\nComparator products sorted: ");
		printProductsInNewLine(comparableProducts);

		comparableProducts.sort(Comparator.reverseOrder());
		System.out.println("\nComparator products reverse order: ");
		printProductsInNewLine(comparableProducts);
	}

	private static void printProductsInNewLine(List<? extends Product> products) {
		for (Product product : products) {
			System.out.println(product);
		}

	}

}