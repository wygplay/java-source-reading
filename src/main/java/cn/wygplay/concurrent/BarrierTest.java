package cn.wygplay.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierTest {
    public static void main(String[] args) {
        final int count = 10;
        CyclicBarrier barrier = new CyclicBarrier(count, () -> System.out.println("All threads have reached the barrier. Let's start the race!"));

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is ready.");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " has started running.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    System.out.println(e.getMessage());
                }
            }).start();
        }
    }
}