package cn.wygplay.concurrent;

import java.util.concurrent.locks.*;

public class AwaitCleanupDemo {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("[T1] calling await()");
                condition.await();  // 将进入 condition 队列
                System.out.println("[T1] woke up normally");
            } catch (InterruptedException e) {
                System.out.println("[T1] interrupted during await()");
            } finally {
                lock.unlock();
            }
        });

        t1.start();

        // 等待线程 t1 进入 await 阻塞状态
        Thread.sleep(1000);

        // 中断线程 t1，模拟未被 signal 的取消
        System.out.println("[Main] interrupting T1");
        t1.interrupt();

        t1.join();

        // 现在条件队列中应该有个已取消的节点，带有 nextWaiter
        // 下次再有线程 await，会触发 unlinkCancelledWaiters() 清理
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("[T2] calling await()");
                condition.await();  // 这里会触发清理 T1 留下的 nextWaiter
            } catch (InterruptedException e) {
                System.out.println("[T2] interrupted during await()");
            } finally {
                lock.unlock();
            }
        });

        t2.start();
        Thread.sleep(1000);
        System.out.println("[Main] signaling T2");
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }

        t2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new AwaitCleanupDemo().test();
    }
}

