package cn.wygplay.java8feature.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class LambdaScopeTest {

    LambdaScope lambda = new LambdaScope();

    @Test
    @DisplayName("lambda表达式访问静态变量")
    void doubleNum() {
        assertEquals(8, lambda.doubleNum(4));
    }

    @Test
    @DisplayName("lambda表达式访问局部变量")
    void threeTimes() {
        assertEquals(9, lambda.threeTimes(3));
    }

    @Test
    @DisplayName("lambda表达式不能直接访问功能函数接口中的默认方法")
    void sqrt() {
        assertEquals(16, lambda.sqrt(4));
    }
}