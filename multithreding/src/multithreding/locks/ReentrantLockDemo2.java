package multithreding.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo2 {

	private Lock lock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {

		var thisInstance = new ReentrantLockDemo2();
		var es = Executors.newFixedThreadPool(4);

		es.execute(() -> System.out.println("Runnable task1 -> 2 + 3: " + thisInstance.calculate("+", 2, 3)));
		es.execute(() -> System.out.println("Runnable task2 -> 7 + 12: " + thisInstance.calculate("+", 7, 12)));
		es.execute(() -> System.out.println("Runnable task3 -> 87 + 4: " + thisInstance.calculate("+", 87, 4)));

		es.execute(() -> System.out.println("Runnable task4 -> 2 - 3: " + thisInstance.calculate("+", 2, 3)));
		es.execute(() -> System.out.println("Runnable task5 -> 57 - 12: " + thisInstance.calculate("+", 57, 12)));
		es.execute(() -> System.out.println("Runnable task6 -> 110 - 7: " + thisInstance.calculate("+", 110, 7)));

		terminateExecutorService(es);
	}

	private static void terminateExecutorService(ExecutorService es) throws InterruptedException {
		es.shutdown();
		es.awaitTermination(3, TimeUnit.SECONDS);
		es.shutdownNow();

	}

	private double calculate(String operation, double operand1, double operand2) {

		try {
			lock.lock();
			System.out.println("Lock is aquired in calculate()");

			switch (operation) {
			case "+":
				return add(operand1, operand2);
			case "-":
				return subtract(operand1, operand2);
			default:
				System.out.println("Calculate works only with + and - operators and two values only");
				return 0;
			}
		} finally {
			lock.unlock();
			System.out.println("Lock is released in calculate()");
		}
	}

	private double subtract(double operand1, double operand2) {
		// lock.lock();
		try {
			lock.lock();
			System.out.println("Lock is aquired in add()");

			return operand1 - operand2;
		} finally {
			lock.unlock();
			System.out.println("Lock is released in add()");
		}
	}

	private double add(double operand1, double operand2) {

		// lock.lock();
		try {
			lock.lock();
			System.out.println("Lock is aquired in add()");

			return operand1 + operand2;
		} finally {
			lock.unlock();
			System.out.println("Lock is released in add()");
		}
	}

}
