package multithreding.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Demo4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		var future = CompletableFuture.supplyAsync(() -> {
			System.out.println("future -> Request user ID from external API....");
			return 1234;
		}).thenApply((result) -> {
			System.out.println("Request total number of purchase in other service by ID...");
			return 999;
		});

		System.out.println(future.get());

		var es = Executors.newCachedThreadPool();
		CompletableFuture.supplyAsync(() -> {
			System.out.println("executor service -> Request Users ID from external API...");
			return 1234;
		}).thenApplyAsync((result) -> {
			System.out.println("Request total number of purchase in other service by ID...");
			return 1050;
		}, es);

		es.shutdown();
	}
}
