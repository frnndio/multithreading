package _1_synchronized;

import util.ThreadLoggerUtil;

public class ConcurrentRunnable  implements Runnable {

    protected int concurrentValue;

    public ConcurrentRunnable(int concurrentValue) {
        this.concurrentValue = concurrentValue;
    }

    @Override
    public void run() {
        ThreadLoggerUtil.LOG.accept(concurrentValue++);
    }

}
