package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapSortingDemo {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(4, "John");
		map.put(5, "Ileana");
		map.put(2, "Ana");
		map.put(10, "Micheal");
		map.put(-1, "Micheal");

		System.out.println("Sorting map by Comparable key");
		List<Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(map.entrySet());

		System.out.print("Shuffle -> ");
		Collections.shuffle(list);
		System.out.println("Entries before sorting: " + list);

		list.sort(Entry.comparingByKey());
		System.out.println("Entries after sorting: " + list);

		// ========== Sorting Map by Comparable Key with TreeMap
		Map<Integer, String> sortedMap = new TreeMap<Integer, String>(map);
		System.out.println("Elements in TreeMap: " + sortedMap);

		// ========== Sorting Map by Comparable Value
		Collections.shuffle(list);
		System.out.println("Entries before sorting: " + list);
		list.sort(Entry.comparingByValue());
		System.out.println("Entrie afted sorting by value " + list);

		// ========== Map.of()
		Map<Integer, String> map2 = Map.of(101, "PP", 102, "QQ", 103, "RR", 104, "FF");
		System.out.println("Map.of()");
		map2.forEach((k, v) -> System.out.println(k + " - " + v));

		List<String> imtList1 = List.of("P1", "Q1");
		List<String> imtList2 = List.of("P1", "Q1");
		Map<Integer, List<String>> map3 = Map.of(111, imtList1, 222, imtList2);
		System.out.println("\n" + map3 + " \n");

		System.out.println("Immutable List");
		List<String> list1 = new ArrayList<String>();
		list1.add("P1");
		list1.add("Q1");
		List<String> list2 = new ArrayList<String>();
		list1.add("P2");
		list1.add("Q2");

		Map<Integer, List<String>> map4 = Map.of(111, list1, 222, list2);
		System.out.println(map4);
		list1.add("R1");
		System.out.println(map4);

		// ========== immutable Map with custom immutable class
		Student s1 = new Student(24, "Mircea");
		Student s2 = new Student(34, "Andrei");

		Map<String, Student> map5 = Map.of("one", s1, "two", s2);
		map5.forEach((k, v) -> System.out.println(k + " " + v.getName()));
	}

}

final class Student {
	final private int age;
	final private String name;

	public Student(final int age, final String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
}