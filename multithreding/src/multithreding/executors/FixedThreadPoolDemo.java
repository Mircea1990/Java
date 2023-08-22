package multithreding.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class FixedThreadPoolDemo {

	public static void main(String[] args) {

		ThreadPoolExecutor es = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

		IntStream.range(0, 4).forEach(i -> {
			es.submit(() -> {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		});

		es.shutdown();
	}
}
