package cn.wygplay.java8feature.functions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    @DisplayName("功能函数与lambda表达式")
    public void testConverterWithLambda() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        assertEquals(345, converter.convert("345"));
    }

    @Test
    @DisplayName("测试关键字'::',静态方法方法引用")
    public void testConverterWithStaticMethodReference() {
        Converter<String, Integer> converter = Integer::valueOf;
        assertEquals(123, converter.convert("123"));
    }

    @Test
    @DisplayName("测试关键字'::',对象方法引用")
    public void testConverterWithObjectMethodReference() {
        Converter<String, String> converter = String::toUpperCase;
        assertEquals("HELLO WORLD", converter.convert("hello world"));
    }

}