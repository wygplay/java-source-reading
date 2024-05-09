package cn.wygplay.java8feature.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 所谓并行流，就是多线程处理的流
 * @author wyg
 * @date 2022/6/22 下午11:53
 */
public class ParallelStreamTest {
    List<String> values;
    @BeforeEach
    public void init() {
        int max = 1000;
        values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
    }

    @Test
    public void testParallelEfficiency() {
        long start = System.nanoTime();
        values.stream().sorted();
        long end = System.nanoTime();
        long duration = end - start;

        long parallelStart = System.nanoTime();
        values.parallelStream().sorted();
        long parallelEnd = System.nanoTime();
        long parallelDuration = parallelEnd - parallelStart;
        System.out.println("sequential sorted costs: " + duration + "nanos");
        System.out.println("parallel sorted costs: " + parallelDuration + "nanos");
        assertTrue(parallelDuration < duration);
    }


}
