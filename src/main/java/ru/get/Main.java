package ru.get;

public class Main {
    public static void main(String[] args) {
        Conf conf = new Conf();
        new Thread(() -> {
            System.out.println("Поток 1 - " + conf.isTracingEnabled());
            conf.enableTracing();
            System.out.println("Поток 1 - " + conf.isTracingEnabled());
        }).start();
        new Thread(() -> {
            System.out.println("Поток 2 - " + conf.isTracingEnabled());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            conf.disableTracing();
            System.out.println("Поток 2 - " + conf.isTracingEnabled());
        }).start();
        System.out.println("коммит 1");
    }
}
