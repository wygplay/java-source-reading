package cn.wygplay.interview.thread;

import java.util.concurrent.*;

public class TaskInterrupt implements Runnable {
    @Override
    public void run() {
        System.out.println("Task is running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Task is interrupted");
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       TaskInterrupt taskInterrupt = new TaskInterrupt();
       Thread t = new Thread(taskInterrupt);
       t.start();
       Thread.sleep(1000);
       t.interrupt();
       Thread.sleep(5000);
       System.out.println(t.isInterrupted());
    }
}
