package multithreding;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo implements Runnable {

//	private static final ThreadLocal<String> transactionId = ThreadLocal.withInitial(() -> "n/a");
	private static final ThreadLocal<Integer> transactionId = new ThreadLocal<Integer>();

	public static void main(String[] args) {

		ThreadLocalDemo runnable = new ThreadLocalDemo();

		var thread1 = new Thread(runnable);
		var thread2 = new Thread(runnable);

		thread1.start();
		thread2.start();
	}

	@Override
	public void run() {
		transactionId.set((int) (Math.random() * 10));
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("Transaction id: " + transactionId.get());
	}

}
