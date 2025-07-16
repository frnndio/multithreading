package _5_executors;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;
import java.util.function.BiFunction;

public class _3_ExecutorWithSubmitExample {

    public static final BiFunction<Integer, ExecutorService, Runnable> MY_RUNNABLE = (tag, executor) -> () -> {
        System.out.printf("%d-XPTO - %s%n", tag, Thread.currentThread().getName());

        // exemplo pro Future.cancel
/*        int timeout = 3;
        for (int i = 0; i < timeout; i++) {
            System.out.printf("%d-XPTO - %s%n", i, Thread.currentThread().getName());
            try {
//                TimeUnit.SECONDS.sleep(1); // curiosidade interrupt não para Thread.sleep
                long start = new Date().getTime();
                while(new Date().getTime() - start < 1000L){}
            } catch (Exception e) {
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

            Future<?> execution = executor.submit(MY_RUNNABLE.apply(1, executor));

            System.out.printf("1 - Is done: %b%n", execution.isDone());
            execution.get();
            System.out.printf("2 - Is done: %b%n", execution.isDone());

            instantStart = Instant.now();
//            executor.shutdown();
//            execution.cancel(true);
            executor.awaitTermination(6, TimeUnit.SECONDS);

            System.out.printf("3 - Is done: %b%n", execution.isDone());

        } catch (Exception e) {
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
