package lang;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    @Test
    void getAndIncrement() {
        AtomicInteger atomicInteger = new AtomicInteger();
        int num = atomicInteger.getAndIncrement();
        assert num == 0;
        assert atomicInteger.get() == 1;
    }
}
