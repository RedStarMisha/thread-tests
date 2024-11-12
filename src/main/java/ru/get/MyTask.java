package ru.get;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {
    private int counter;
    private ScheduledExecutorService scheduledExecutorService;
    @Override
    public void run() {
        Runnable runnable = () -> {
            System.out.println("count - " + counter);
            counter++;
        };
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
    }

    public void shutdown() {
        scheduledExecutorService.shutdown();
    }
}
