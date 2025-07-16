package _5_executors;

import util.ThreadLoggerUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class _1_ExecutorWithExecuteExample {

    public static final String LOG_PATTERN = "%d-XPTO - %s%n";

    public static final Function<Integer, Runnable> MY_RUNNABLE_1 = tag -> () ->
            System.out.printf(LOG_PATTERN, tag, Thread.currentThread().getName());

    public static final Function<Integer, Runnable> MY_RUNNABLE_2 = tag -> () -> {
            System.out.printf("%d-XPTO - %s%n", tag, Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

    public static void main(String[] args) throws InterruptedException {

        ThreadLoggerUtil.LOG.accept(1);

        // como o nome já diz, executor com 1 thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(MY_RUNNABLE_1.apply(2));
        /*executor.submit(MY_RUNNABLE_2.apply(3));
        executor.submit(MY_RUNNABLE_1.apply(4));*/

        System.out.printf("it ended (false) - %s%n", Thread.currentThread().getName());

        //executor.shutdown();

        while (!executor.isTerminated()) {
            /*ThreadLoggerUtil.LOG.accept(5);
            TimeUnit.SECONDS.sleep(1);*/
        }

        System.out.printf("now it's really ended - %s%n", Thread.currentThread().getName());

    }

}
