package concurrent.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

class ConcurrentHashMapTest {

    @Test
    void debugTransfer() {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put(i, "wygplay" + i);
        }

    }
}