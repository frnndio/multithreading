package _5_executors;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _6_FixedExecutorExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> execution1 = executor.submit(new MyCallable(1));
        Future<String> execution2 = executor.submit(new MyCallable(2));
        Future<String> execution3 = executor.submit(new MyCallable(3));
        Future<String> execution4 = executor.submit(new MyCallable(4));
        Future<String> execution5 = executor.submit(new MyCallable(5));

       /* System.out.println(execution1.get());
        System.out.println(execution2.get());
        System.out.println(execution3.get());
        System.out.println(execution4.get());
        System.out.println(execution5.get());*/

        executor.shutdown();

    }
}
