package cn.wygplay.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        final int count = 10;
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(count);
        CountDownLatch startGate = new CountDownLatch(1);

        for (int i = 0; i < count; i++) {
            final int constant = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        map.put(constant + "", Thread.currentThread().getName());
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
        startGate.countDown();
        countDownLatch.await();
        map.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
    }
}

