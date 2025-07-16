package _5_executors;


import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _7_CachedExecutorExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // se a thread ficar 60 segundos sem ser utilizada, ela é terminada e removida do cache
        // ter cuidado pq ele "não tem limite" (Integer.MAX_VALUE) de threads
        ExecutorService executor = Executors.newCachedThreadPool();

        executeExample(executor);

        //Set<Callable<String>> tasks = buildTasks(5);

        // invokeAll example

        /*List<Future<String>> executionResults = executor.invokeAll(tasks);

        for (Future<String> execution : executionResults) {
            System.out.println(execution.get());
        }*/

        // invokeAny example

        /*String anyExecutionResult = executor.invokeAny(tasks);
        System.out.println(anyExecutionResult);*/

        executor.shutdown();

    }

    private static void executeExample(ExecutorService executor) throws ExecutionException, InterruptedException {
        
        Future<String> execution1 = executor.submit(new MyCallable(1));
        Future<String> execution2 = executor.submit(new MyCallable(2));
//        execution1.get();
//        execution2.get();
        Future<String> execution3 = executor.submit(new MyCallable(3));
        Future<String> execution4 = executor.submit(new MyCallable(4));
        Future<String> execution5 = executor.submit(new MyCallable(5));

        /*System.out.println(execution1.get());
        System.out.println(execution2.get());
        System.out.println(execution3.get());
        System.out.println(execution4.get());
        System.out.println(execution5.get());*/
    }

    private static Set<Callable<String>> buildTasks(int amount) {
        return IntStream.rangeClosed(1, amount)
                .mapToObj(MyCallable::new)
                .collect(Collectors.toUnmodifiableSet());
    }
    
}
