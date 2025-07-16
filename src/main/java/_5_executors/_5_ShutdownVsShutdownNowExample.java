package _5_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _5_ShutdownVsShutdownNowExample {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(() -> {
            while (true) {
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()) {
                    System.out.printf("Thread interrupted! - %s%n", currentThread.getName());
                    break;
                }
            }
        });

        executor.shutdown();
//        executor.shutdownNow();

        int timeout = 5;

        if (!executor.awaitTermination(timeout, TimeUnit.SECONDS)) {
            System.out.printf("Still waiting after %d seconds, calling System.exit(0)%n", timeout);
            System.exit(0);
        }

        System.out.println("Exiting normally...");

    }

}
