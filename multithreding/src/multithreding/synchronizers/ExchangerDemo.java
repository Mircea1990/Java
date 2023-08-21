package multithreding.synchronizers;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;

public class ExchangerDemo {

	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();

		Runnable task1 = () -> {
			try {
				String msg = exchanger.exchange("Message from Task #1");
				System.out.println("Receive from another thread in task #1: " + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Runnable task2 = () -> {
			try {
				String msg = exchanger.exchange("Message from Task #2");
				System.out.println("Receive from another thread in task #2: " + msg);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
		};

		var es = Executors.newCachedThreadPool();
		es.submit(task1);
		es.submit(task2);

		es.shutdown();
	}

}
