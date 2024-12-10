package ru.get;

public class NonVolatileExample {
    private boolean running = true; // не volatile

    public void run() {
        while (running) {
            // Выполняем какую-то работу
        }
        System.out.println("Работа остановлена.");
    }

    public void stop() {
        running = false; // Изменяем переменную
    }

    public static void main(String[] args) throws InterruptedException {
        NonVolatileExample example = new NonVolatileExample();
        Thread thread = new Thread(example::run);
        thread.start();

        // Ждем 1 секунду, чтобы дать потоку поработать
        Thread.sleep(1000);
        example.stop(); // Останавливаем выполнение

        thread.join(); // Ждем завершения потока
    }
}
