package _5_executors;

import util.ThreadLoggerUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<String> {

    private final int tag;

    public MyCallable(int tag) {
        this.tag = tag;
    }

    @Override
    public String call() throws InterruptedException {
        ThreadLoggerUtil.LOG.accept(tag);
        TimeUnit.SECONDS.sleep(2);
        return "%d - My Callable - %s".formatted(tag, Thread.currentThread().getName());
    }

}
