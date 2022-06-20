package cn.wygplay.java8feature.functions;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Comparator功能接口
 * String类中比较时忽略大小写的方法应用到了Comparator接口;
 * @see java.lang.String#compareToIgnoreCase(java.lang.String)
 * @author wyg
 * @date 2022/6/20 下午11:03
 */
public class ComparatorTest {
    @Test
    public void test() {
        Comparator<Car> comparator = (carA, carB) -> carA.getName().compareTo(carB.getName());
        Car carA = new Car("BYD");
        Car carB = new Car("TESLA");
        assertFalse(comparator.compare(carA, carB) > 0);
    }

    @Test
    public void reversed() {
        Comparator<Car> comparator = (carA, carB) -> carA.getName().compareTo(carB.getName());
        Car carA = new Car("BYD");
        Car carB = new Car("TESLA");
        assertTrue(comparator.reversed().compare(carA, carB) > 0);
    }


}
