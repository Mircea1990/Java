package multithreding;

import java.util.concurrent.TimeUnit;

public class DaemonThreadDemo {

	public static void main(String[] args) throws InterruptedException {

		var t1 = new Thread(() -> {
			while (true) {
				try {
					TimeUnit.MILLISECONDS.sleep(500);
					System.out.println("Deamon Thread is working in background");
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
		});

		t1.start();

		TimeUnit.SECONDS.sleep(2);
		System.out.println("Main thread finished");
	}

}
