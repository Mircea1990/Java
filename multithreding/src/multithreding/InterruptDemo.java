package multithreding;

import java.util.concurrent.TimeUnit;

public class InterruptDemo implements Runnable {

	public static void main(String[] args) throws InterruptedException {

		InterruptDemo runnableTask = new InterruptDemo();
		Thread thread = new Thread(runnableTask);
		thread.start();

		Thread.sleep(2000);

		System.out.println("in main() interrupting other thread");

		thread.interrupt();

		thread.join();
		System.out.println("in main() - leaving");
	}

	@Override
	public void run() {
		try {
			System.out.println("In run() - about to work()");
			work();
			System.out.println("In run() - back from work() - this line will not be executed");
//		} catch (InterruptedException e) {
		} catch (Exception e) {
			System.out.println("In run() - interrupted in work()");
			return;
		}
		System.out.println("In run() - doing stuff after nap");
		System.out.println("In run() - leaving normally");
	}

	private void work() throws InterruptedException {
		while (true) {
			System.out.println("Working...");
			if (Thread.currentThread().isInterrupted()) {

				System.out.println("isInterrupted(): " + Thread.currentThread().isInterrupted());
				// System.out.println("interrupted(): " + Thread.interrupted());
				// System.out.println("isInterrupted(): " +
				// Thread.currentThread().isInterrupted());

				TimeUnit.MILLISECONDS.sleep(1);

				System.out.println("This line won't be executed");
			}
		}

	}

}
