package cn.wygplay.java8feature.functions;

import cn.wygplay.java8feature.reference.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 内建函数接口Predicate测试
 * boolean value 函数
 * @author wyg
 * @date 2022/6/19 20:55
 */
public class PredicateTest {
    @Test
    public void predicate() {
        Predicate<String> isNotEmpty = s -> s != null && s.trim().length() > 0;
        assertTrue(isNotEmpty.test("zhangsan"));
        assertFalse(isNotEmpty.test(""));
        assertTrue(Predicate.isEqual("test").test("test"));

        Predicate<Person> nonNull = Objects::nonNull;
        assertFalse(nonNull.test(null));
    }

    @Test
    @DisplayName("用and实现字符非空，非null的判断")
    public void and() {
        Predicate<String> isNotNull = Objects::nonNull;
        Predicate<String> isNotEmpty = s -> s.trim().length() > 0;
        assertTrue(isNotNull.and(isNotEmpty).test("test"));
        assertFalse(isNotNull.and(isNotEmpty).test(null));
    }

    @Test
    @DisplayName("用or实现大于5，小于0的值判断")
    public void or() {
        Predicate<Integer> gtFive = num -> num > 5;
        Predicate<Integer> ltZero = num -> num < 0;
        assertTrue(gtFive.or(ltZero).test(-1));
        assertTrue(gtFive.or(ltZero).test(6));
    }
}
