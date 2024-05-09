package util;

import org.junit.jupiter.api.Test;

public class HashMapTest {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    @Test
    void tableSizeFor() {
        System.out.println(tableSizeFor(5));
    }

    @Test
    void hash() {
        System.out.println(5 & 7);
        System.out.println(5 & 8);
        System.out.println(5 & 9);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
