package cn.wygplay.java8feature.functions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author wyg
 * @date 2022/6/19 21:59
 */
public class FunctionInterfaceTest {
    @Test
    public void FunctionTest() {
        Function<String, String> toUpperCase =  String::toUpperCase;

        assertEquals("HELLO WORLD", toUpperCase.apply("hello world"));
        assertEquals("no change", Function.identity().apply("no change"));

        Function<Car, String> carName = Car::getName;
        Car car = new Car();
        car.setName("tesla");
        assertEquals("tesla", carName.apply(car));
    }

    @Test
    @DisplayName("实现(x + 5) * 2的计算")
    public void anThen() {
        Function<Integer, Integer> addFive = num -> num + 5;
        assertEquals(20, addFive.andThen(num -> num * 2).apply(5));
        assertNotEquals(15, addFive.andThen(num -> num * 2).apply(5));
    }

    @Test
    @DisplayName("实现 x * 2 + 5 的计算")
    public void compose() {
        Function<Integer, Integer> addFive = num -> num + 5;
        Function<Integer, Integer> doubleNum = num -> num * 2;
        // TODO compose参数直接传入doubleNum的lambda表达式（num * 2）ide报错，原因：compose的参数实际是一个Function对象（假设为B），
        //  B对象apply的返回值类型与调用compose方法的对象（A对象），apply函数参数类型一致；但对于B对象，参数是没有限制的；
        // 因此但在compose参数直接传递lambda表达式时，是无法指明参数类型的，所以表达式出现运算符时出现了错误提示
        assertEquals(15, addFive.compose(doubleNum).apply(5));
        assertNotEquals(20, addFive.compose(doubleNum).apply(5));
    }
}
