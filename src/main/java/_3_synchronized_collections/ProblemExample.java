package _3_synchronized_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProblemExample {

    private static List<String> myList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

//        myList = Collections.synchronizedList(myList);

        AtomicInteger counter = new AtomicInteger();

        for (int i = 0; i < 150; i++) {
            myList.clear();
            TimeUnit.MILLISECONDS.sleep(20);
            executeExample(myList, counter.incrementAndGet());
        }

    }

    public static void executeExample(Collection<String> collection, int externalCounter) throws InterruptedException {

        AtomicInteger internalCounter = new AtomicInteger();

        Runnable myRunnable = () -> {
            int counter = internalCounter.incrementAndGet();
            collection.add("XPTO-" + counter);
            System.out.printf("%-3d %d execution - %s added to the collection!%n",
                    externalCounter, counter, Thread.currentThread().getName());
        };

        int amount = 5;

        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        Thread t3 = new Thread(myRunnable);
        Thread t4 = new Thread(myRunnable);
        Thread t5 = new Thread(myRunnable);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        /*IntStream.range(0, amount)
                .mapToObj(i -> new Thread(myRunnable))
                .forEach(Thread::start);*/

        TimeUnit.MILLISECONDS.sleep(20);

        String failWarning = collection.size() != amount ? "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< FAIL" : "";

        System.out.printf("%s %s%n", collection, failWarning);
    }

}
