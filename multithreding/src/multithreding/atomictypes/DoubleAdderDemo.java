package multithreding.atomictypes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;

public class DoubleAdderDemo {

	private static DoubleAdder doubleAdder = new DoubleAdder();

	public static void main(String[] args) throws InterruptedException {

		List<Thread> allThreads = new ArrayList<Thread>();
		int numOfIncrements = 10000;

		for (int i = 0; i < numOfIncrements; i++) {
			var t = new Thread(AtomicIntegerDemo::increment);
			allThreads.add(t);
			t.start();
		}

		for (Thread thread : allThreads) {
			thread.join();
		}

		System.out.println(doubleAdder.doubleValue());
	}

	public static void increment() {
		doubleAdder.add(1.1);
	}
}
