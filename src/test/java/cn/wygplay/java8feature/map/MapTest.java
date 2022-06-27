package cn.wygplay.java8feature.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Map 本身不支持Stream化，但可以通过keySet、valuesSet、entrySet来间接实现
 * @author wyg
 * @date 2022/6/23 上午12:46
 */
public class MapTest {
    Map<Integer, String> map = new HashMap<>();

    @BeforeEach
    public void init() {
        IntStream.range(1, 10).forEach(i -> map.putIfAbsent(i, "test" + i));
    }

    @Test
    public void computeIfPresent() {
        map.computeIfPresent(5, (key, value) -> value + key);
        assertEquals("test55", map.get(5));
    }

    @Test
    public void computeIfAbsent() {
        map.computeIfAbsent(11, key -> "test" + key + key);
        assertEquals("test1111", map.get(11));
    }

    @Test
    public void getOrDefaultTest() {
        assertEquals("not found", map.getOrDefault(11, "not found"));
    }

    @Test
    public void mergeTest() {
        assertEquals("test9hello", map.merge(9, "hello", (value, newValue) -> value.concat(newValue)));
        assertEquals("test9hello", map.get(9));
    }
}

