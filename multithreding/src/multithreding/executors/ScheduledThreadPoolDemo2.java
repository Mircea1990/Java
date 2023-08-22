package multithreding.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo2 {

	private static int counter1 = 0;
	private static int counter2 = 0;

	public static void main(String[] args) throws InterruptedException {

		var es = Executors.newScheduledThreadPool(4);

		es.scheduleAtFixedRate(() -> {
			System.out.println("Hello");
			counter1++;
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
			}
		}, 500, 1000, TimeUnit.MILLISECONDS);

		es.awaitTermination(7, TimeUnit.SECONDS);
		System.out.println("counter1: " + counter1);
		es.shutdownNow();

		System.out.println("--------------------------------");

		var es2 = Executors.newScheduledThreadPool(4);

		es2.scheduleWithFixedDelay(() -> {
			System.out.println("World");
			counter2++;
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
			}
		}, 500, 1000, TimeUnit.MILLISECONDS);

		es2.awaitTermination(7, TimeUnit.SECONDS);
		System.out.println("counter2: " + counter2);
		es2.shutdownNow();
	}

}
