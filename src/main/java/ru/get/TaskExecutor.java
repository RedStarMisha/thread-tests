package ru.get;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskExecutor {

    public void executeMyTask() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyTask myTask = new MyTask();
        Future<?> future = executorService.submit(myTask);
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            myTask.shutdown();
            executorService.shutdown();
        }).start();
    }

    public void executeMyTask2() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(new Mytask2());
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            future.cancel(true);
            executorService.shutdown();
        }).start();
    }
}
