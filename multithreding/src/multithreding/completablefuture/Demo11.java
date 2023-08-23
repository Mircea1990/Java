package multithreding.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Demo11 {

	public static void main(String[] args) {
		List<String> messages = Arrays.asList("a", "b", "c");
		List<CompletableFuture<String>> futures = messages.stream()
				.map(msg -> CompletableFuture.completedFuture(msg).thenApply(Demo10::delayedUpperCase))
				.collect(Collectors.toList());

		CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res, th) -> {
			if (th == null) {
				System.out.println(res);
			}
		});

	}

	static String delayedUpperCase(String s) {
		randomSleep();
		return s.toUpperCase();
	}

	static void randomSleep() {
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(3));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
