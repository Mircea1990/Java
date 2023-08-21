package multithreding.synchronizers;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CyclicBarrierDemo {

	private static final int NUMBER_OR_THREADS = 4;
	private static final int NUMBERS_TO_GENERATE = 3;
	private static final int MAXIMUM_RANDOM_NUMBER = 100;

	private static CyclicBarrier barrier;
	private List<Integer> generateNumbers = new CopyOnWriteArrayList<Integer>();
	private Random random = new Random();

	public static void main(String[] args) {

		var demo = new CyclicBarrierDemo();
		barrier = new CyclicBarrier(NUMBER_OR_THREADS, demo::numberGenerationCallback);

		var ex = Executors.newFixedThreadPool(MAXIMUM_RANDOM_NUMBER);
		IntStream.range(0, NUMBER_OR_THREADS).forEach(i -> ex.submit(demo::generateNumbers));
		System.out.println("getParties():" + barrier.getParties());

		ex.shutdown();
	}

	private void numberGenerationCallback() {

		int max = generateNumbers.stream().mapToInt(i -> i).max().getAsInt();
		System.out.println("All generated numbers: " + generateNumbers);
		System.out.println("Maximum: " + max);
	}

	private void generateNumbers() {
		for (int i = 0; i < NUMBERS_TO_GENERATE; i++) {
			generateNumbers.add(random.nextInt());
		}
		try {
			System.out.println("await(): " + barrier.await());
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
