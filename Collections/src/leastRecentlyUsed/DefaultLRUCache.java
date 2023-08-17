package leastRecentlyUsed;

import java.util.LinkedHashMap;

public class DefaultLRUCache extends LinkedHashMap<Integer, Integer> implements LRUCache {

	private int capacity;

	public DefaultLRUCache() {
		super(16, 0.67f, true);
	}

	public DefaultLRUCache(int capacity) {
		super(16, 0.67f, true);
		this.capacity = capacity;
	}

	@Override
	public int get(int key) {
		Integer result = super.get(key);
		if (result == null)
			return -1;
		return super.get(key);
	}

	@Override
	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	public void setCatapity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
		if (size() > capacity)
			return true;
		return false;
	}

	public static void main(String[] args) {
		DefaultLRUCache lruCache = new DefaultLRUCache(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(1));

		lruCache.put(3, 3);
		System.out.println(lruCache.get(2));
		lruCache.put(4, 4);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));
	}
}
