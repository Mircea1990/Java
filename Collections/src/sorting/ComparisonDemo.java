package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import onlineshop.enteties.Product;
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

	}

	private static void printProductsInNewLine(List<? extends Product> products) {
		for (Product product : products) {
			System.out.println(product);
		}

	}

}