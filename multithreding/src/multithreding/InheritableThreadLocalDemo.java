package multithreding;

import java.util.concurrent.TimeUnit;

public class InheritableThreadLocalDemo {

	private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<String>();

	public static void main(String[] args) {

		Thread thread1 = new Thread(() -> {
			System.out.println("-------------Thread #1-------------");
			threadLocal.set("-------------Thread #1 - ThreadLocal-------------");
			inheritableThreadLocal.set("-------------Thread #1 - InheritableThreadLocal-------------");

			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());

			Thread childThread = new Thread(() -> {
				System.out.println("-------------Child Thread-------------");
				System.out.println(threadLocal.get());
				System.out.println(inheritableThreadLocal.get());
			});
			childThread.start();
		});

		thread1.start();

		Thread thread2 = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}

			System.out.println("-------------Thread #2-------------");
			System.out.println(threadLocal.get());
			System.out.println(inheritableThreadLocal.get());
		});

		thread2.start();
	}

}
