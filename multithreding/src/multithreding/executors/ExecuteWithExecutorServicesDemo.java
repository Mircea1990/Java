package multithreding.executors;

import java.util.concurrent.Executors;

public class ExecuteWithExecutorServicesDemo {

	public static void main(String[] args) {
		var es = Executors.newCachedThreadPool();
		es.execute(() -> System.out.println("Hello from thread " + Thread.currentThread().getName()));
		es.execute(() -> System.out.println("Hello from thread " + Thread.currentThread().getName()));

		es.shutdown();
	}

}
