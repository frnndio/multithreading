package _1_synchronized;

public class SynchronizedBlock extends ConcurrentRunnable {

    public SynchronizedBlock(int concurrentValue) {
        super(concurrentValue);
    }

    @Override
    public void run() {

        System.out.printf("start - %s%n", getClass().getSimpleName());

        synchronized (this) {
            super.run();
        }

        System.out.printf("end - %s%n", getClass().getSimpleName());

        // Any synchronized method or block has to lock on some shared object.
        /*synchronized (SynchronizedBlock.class) {
            super.run();
        }*/

    }

}
