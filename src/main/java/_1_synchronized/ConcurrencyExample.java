package _1_synchronized;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyExample {

    private static int concurrentValue = -50;

    public static void main(String[] args) {

        Runnable myRunnable = new ConcurrentRunnable(concurrentValue);
//        Runnable myRunnable = new SynchronizedMethod(concurrentValue);
//        Runnable myRunnable = new SynchronizedBlock(concurrentValue);

        int amount = 100;

        List<Thread> threads = new ArrayList<>(amount);

        for (int i = 0; i < amount; i++) {
            threads.add(new Thread(myRunnable));
        }

        threads.forEach(Thread::start);

    }

}
