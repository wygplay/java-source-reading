package cn.wygplay.java8feature.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author wyg
 * @date 2022/6/20 下午11:50
 */
public class OptionalTest {
    @Test
    public void test() {
        Optional<String> optional = Optional.of("guanyu");
        assertTrue(optional.isPresent());
        assertEquals("guanyu", optional.get());
    }

    @Test
    @DisplayName("optional对象为empty时，调用orElse方法会返回orElse参数")
    public void orElse() {
        Optional<String> nullOptional = Optional.ofNullable(null);
        Optional<String> optional = Optional.of("关羽");
        assertEquals("zhangfei", nullOptional.orElse("zhangfei"));
        assertEquals("关羽", optional.orElse("张飞"));
    }
}
