package _4_thread_safe_collections;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static _3_synchronized_collections.ProblemExample.executeExample;

public class ProblemExample {

    // pesada e menos perfomática, sempre que é feita alguma modificação (add/remove), faz uma cópia do array inteiro
    private static List<String> myList = new CopyOnWriteArrayList<>();

    // mais perfomática
//    private static Set<String> myList = ConcurrentHashMap.newKeySet();

//    private static Queue<String> myList = new LinkedBlockingQueue<>();
//    private static Deque<String> myList = new LinkedBlockingDeque<>();

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger counter = new AtomicInteger();

        for (int i = 0; i < 150; i++) {
            myList.clear();
            TimeUnit.MILLISECONDS.sleep(20);
            executeExample(myList, counter.incrementAndGet());
        }

    }
}
