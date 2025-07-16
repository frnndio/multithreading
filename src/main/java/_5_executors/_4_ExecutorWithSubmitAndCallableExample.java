package _5_executors;

import util.ThreadLoggerUtil;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public class _4_ExecutorWithSubmitAndCallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> execution = executor.submit(new MyCallable(2));

        System.out.printf("1 - Is done: %b%n", execution.isDone());
        Instant instantStart = Instant.now();
        System.out.println(execution.get());
//        System.out.println(execution.get(1, TimeUnit.SECONDS));
        System.out.printf("3 - Is done: %b%n", execution.isDone());

        executor.shutdown();

        System.out.printf("now it's really ended, it took %d seconds - %s%n",
                Duration.between(instantStart, Instant.now()).getSeconds(), Thread.currentThread().getName());

    }

}
