package _0_thread;

import util.ThreadLoggerUtil;

public class ThreadExample {

    public static void main(String[] args) {

        ThreadLoggerUtil.LOG.accept(1);

        /*Thread myThread = new Thread(new MyRunnable(2));

        myThread.run();
        myThread.start();*/

        //new Thread(() -> LOG.accept(3)).start();
    }

}
