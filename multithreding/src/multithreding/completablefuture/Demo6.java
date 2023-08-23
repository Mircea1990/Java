package multithreding.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Demo6 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		var future = CompletableFuture.runAsync(() -> {
			System.out.println("Saving user profile via external API...");
		}).thenRun(() -> {
			System.out.println("User profile saved");
		});

		System.out.println(future.get());

		var es = Executors.newCachedThreadPool();
		CompletableFuture.runAsync(() -> {
			System.out.println("Saving user profile via external API...");
		}).thenRunAsync(() -> {
			System.out.println("User profile saved");
		}, es);

		es.shutdown();
	}

}
