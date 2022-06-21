package cn.wygplay.java8feature.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * stream操作分为intermediate与terminal（方法返回值类型为非Stream类型），
 * 执行terminal操作后，流关闭，不能重复使用
 * @author wyg
 * @date 2022/6/22 上午12:39
 */
public class StreamTest {
    List<String> stringCollection = new ArrayList<>();

    @BeforeEach
    public void init() {
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }

    @Test
    public void filter() {
        stringCollection.stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    @Test
    public void sorted() {
        // sorted不会改变原集合中元素顺序
        stringCollection.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void map() {
        // 在原stream基础上，通过map中函数的处理相应的元素，生成新的stream
        stringCollection.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    public void match() {
        assertTrue(stringCollection.stream().anyMatch(s -> s.startsWith("a")));
        assertFalse(stringCollection.stream().allMatch(s -> s.startsWith("a")));
        assertTrue(stringCollection.stream().noneMatch(s -> s.startsWith("g")));
    }

    @Test
    public void reduce() {
        Optional<String> reduced = stringCollection
                .stream()
                .reduce((s, t) -> s + "#" + t);
        reduced.ifPresent(System.out::println);
    }

}
