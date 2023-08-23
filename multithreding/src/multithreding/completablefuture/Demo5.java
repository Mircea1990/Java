package multithreding.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Demo5 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		var future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Request user profile from external API...");
			return "Some string represantation of user profile";
		}).thenAccept((result) -> {
			System.out.println("User profile received: " + result);
		});

		System.out.println(future.get());
		System.out.println(future.isDone());

		var es = Executors.newCachedThreadPool();
		CompletableFuture.supplyAsync(() -> {
			System.out.println("Request user profile from external API...");
			return "Some string representation of user profile";
		}).thenAcceptAsync((result) -> {
			System.out.println("User profile received: " + result);
		}, es);

		System.out.println(es.toString());

		es.shutdown();
	}

}
