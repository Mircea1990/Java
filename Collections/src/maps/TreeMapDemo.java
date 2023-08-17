package maps;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.TreeMap;

import onlineshop.enteties.Product;
import onlineshop.enteties.User;
import onlineshop.enteties.impl.DefaultProduct;
import onlineshop.enteties.impl.DefaultUser;

public class TreeMapDemo {

	public static void main(String[] args) {
		NavigableMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(1, "one");
		treeMap.put(5, "five");
		treeMap.put(2, "two");
		treeMap.put(4, "four");
		treeMap.put(3, "three");

		System.out.println("Get first entry: " + treeMap.firstEntry());
		System.out.println("Get lower entry for 3: " + treeMap.lowerEntry(3));
		System.out.println("Get floor entry for 3: " + treeMap.floorEntry(3));
		System.out.println("Get higher entry for 3: " + treeMap.higherEntry(3));
		System.out.println("Get ceiling entry for 3: " + treeMap.ceilingEntry(3));

		System.out.println("\nSorted treeMap: \n" + treeMap);
		System.out.println();
		System.out.println("\nDescending oirder: \n" + treeMap.descendingMap());

		System.out.println();
		NavigableMap<Product, User> productUserMap = new TreeMap<Product, User>(new CustomProductComparator());
		productUserMap.put(new DefaultProduct(2, "Oregon Cottage Interior Oak Door", "Doors", 9.67), new DefaultUser());
		productUserMap.put(new DefaultProduct(1, "Hardwood Oak Suffolk Internal Door", "Doors", 109.98),
				new DefaultUser());

		System.out.println("\nKeys are sorted according to Comparator : ");
		for (Product product : productUserMap.keySet()) {
			System.out.println(product);
		}
	}

}

class CustomProductComparator implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		int result = product1.getProductName().compareTo(product2.getProductName());
		if (result == 0) {
			double priceDelta = product2.getPrice() - product1.getPrice();
			result = priceDelta < 0 ? -1 : (priceDelta == 0) ? 0 : 1;
		}
		return result;
	}

}