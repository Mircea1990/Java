package maps;

public class LinkedHashMapDemo extends java.util.LinkedHashMap<Integer, String> {

	private int capacity = 3;

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<Integer, String> eldest) {
		if (size() > this.capacity)
			return true;
		return false;
	}

	public static void main(String[] args) {
		LinkedHashMapDemo demo = new LinkedHashMapDemo();

		demo.put(1, "one");
		demo.put(2, "two");
		demo.put(3, "three");
		demo.put(4, "four");

		System.out.println(demo);
	}
}
