package cn.wygplay.concurrent;

public class VolatileOrderTest {
    private static volatile int a = 0;
    private static volatile int b = 0;
    private static volatile int x = 0;
    private static volatile int y = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            a = 1; // 1
            x = b; // 2
        });

        Thread thread2 = new Thread(() -> {
            b = 1; // 3
            y = a; // 4
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("x: " + x + ", y: " + y);
    }
}
