package cn.wygplay.thread;

public class InterruptedTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is running");
            }
            System.out.println("Thread is interrupted");
            if (Thread.interrupted()) {
                System.out.println("Thread status is not cleared");
            }
            System.out.println("Thread is interrupted: " + Thread.currentThread().isInterrupted());
        });

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
