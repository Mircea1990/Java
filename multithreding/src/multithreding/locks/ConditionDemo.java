package multithreding.locks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

	private static final int CAPACITY = 5;

	private Deque<String> stack = new LinkedList<String>();
	private Lock lock = new ReentrantLock();
	private Condition stackEmptyCondition = lock.newCondition();
	private Condition stackFullCondition = lock.newCondition();

	public static void main(String[] args) {

		var demo = new ConditionDemo();
		System.out.println("Demo class initialize");
		var es = Executors.newFixedThreadPool(4);

		es.submit(() -> demo.pushToStack("test String #1"));
		es.submit(() -> System.out.println(demo.popFromStack()));

		es.shutdown();
	}

	private void pushToStack(String item) {
		try {
			lock.lock();
			System.out.println("Acquires the lock in push() ");
			while (stack.size() == CAPACITY) {
				stackFullCondition.await();
				System.out.println("current thread is waiting.....");
			}
			stack.push(item);
			System.out.println("stack item pushed....");

			stackEmptyCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("Releases the lock in push()");
		}
	}

	private String popFromStack() {
		try {
			lock.lock();
			System.out.println("Acquires the lock in pop method ");
			while (stack.size() == 0) {
				stackEmptyCondition.await();
				System.out.println("current thread is waiting.....");
			}
			return stack.pop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			stackFullCondition.signalAll();
			System.out.println("Wakes up all waiting threads in pop()");
			lock.unlock();
			System.out.println("Releases the lock in pop()");
		}
		return "";
	}

}
