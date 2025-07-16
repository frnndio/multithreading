package util;

import java.time.LocalTime;
import java.util.function.Consumer;

public class ThreadLoggerUtil {

    private static final String LOG_PATTERN = "%-20s %-5d %-15s%n";

    public static final Consumer<Integer> LOG = tag -> System.out.printf(LOG_PATTERN,
            LocalTime.now(), tag, Thread.currentThread().getName());

}
