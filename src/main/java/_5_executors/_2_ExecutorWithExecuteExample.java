package _5_executors;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class _2_ExecutorWithExecuteExample {

    public static final BiFunction<Integer, ExecutorService, Runnable> MY_RUNNABLE = (tag, executor) -> () -> {
        System.out.printf("%d-XPTO - %s%n", tag, Thread.currentThread().getName());

        /*for (int i = 0; i < 3; i++) {
            System.out.printf("%d-XPTO - %s%n", i, Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        executor.shutdown();*/

    };

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = null;
        Instant instantStart = null;

        try {

            executor = Executors.newSingleThreadExecutor();

            executor.execute(MY_RUNNABLE.apply(1, executor));

            instantStart = Instant.now();
            executor.awaitTermination(7, TimeUnit.SECONDS);
//            instantStart = Instant.now();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {

            if (executor != null) {
                executor.shutdownNow(); //
            }

            System.out.printf("now it's really ended, it took %d seconds - %s%n",
                    Duration.between(instantStart, Instant.now()).getSeconds(), Thread.currentThread().getName());
        }

    }

}
