package cn.wygplay.interview;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {
    @Test
    void threadLocalTest() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("wyg");
        System.out.println(threadLocal.get());
        System.out.println(Thread.currentThread());
    }
}
