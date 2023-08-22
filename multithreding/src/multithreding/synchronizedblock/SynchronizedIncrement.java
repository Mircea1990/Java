package multithreding.synchronizedblock;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedIncrement {

	private static int counter;

	public static void main(String[] args) throws InterruptedException {

		List<Thread> threads = new ArrayList<Thread>();
		int numberOfIncrements = 10000;

		for (int i = 0; i < numberOfIncrements; i++) {
			var t = new Thread(SynchronizedIncrement::increment);
			threads.add(t);
			t.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

		System.out.println(counter);
	}

	public synchronized static void increment() {
		counter++;
	}

}
