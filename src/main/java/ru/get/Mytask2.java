package ru.get;

public class Mytask2 implements Runnable {
    private int counter;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(counter++);
        }
    }
}
