package qiang.hu.concurrent;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) {
        {
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Hello";
            });

            CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "world";
            });
            System.out.println("Submitted: " + LocalTime.now());

            CompletableFuture.allOf(future1, future2).whenComplete((s, throwable) -> {
                System.out.println("Completed: " + LocalTime.now());
                if (throwable != null) {
                    System.out.println("Error: " + throwable.getMessage());
                } else {
                    System.out.println("Result: " + future1.getNow("default") + " " + future2.getNow("default"));
                }
            });
        }
    }
}
