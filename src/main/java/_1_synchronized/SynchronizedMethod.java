package _1_synchronized;

public class SynchronizedMethod extends ConcurrentRunnable {

    public SynchronizedMethod(int concurrentValue) {
        super(concurrentValue);
    }

    @Override
    public synchronized void run() {

        System.out.printf("start - %s%n", getClass().getSimpleName());

        super.run();

        System.out.printf("end - %s%n", getClass().getSimpleName());

    }

}
