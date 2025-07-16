package _0_thread;

import util.ThreadLoggerUtil;

public class MyRunnable implements Runnable {

    private final int tag;

    public MyRunnable(int tag) {
        this.tag = tag;
    }

    @Override
    public void run() {
        ThreadLoggerUtil.LOG.accept(tag);
    }

}
