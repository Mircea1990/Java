package utils;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class CollectionsDemo {

	public static void main(String[] args) {

		try {
			Map<String, Boolean> map = new WeakHashMap<String, Boolean>();
			System.out.println("Map is: " + map);

			// map.put("1", true);

			Set<String> set = Collections.newSetFromMap(map);

			set.add("A");
			set.add("B");
			set.add("C");
			set.add("D");
			set.add("E");

			System.out.println("Map is: " + map);
			System.out.println("Set from Map is: " + set);
		} catch (IllegalArgumentException exception) {
			System.out.println("Exception thrown: " + exception);
		}

	}

}
