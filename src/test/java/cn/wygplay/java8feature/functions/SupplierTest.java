package cn.wygplay.java8feature.functions;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Supplier不包含参数
 * @author wyg
 * @date 2022/6/19 22:45
 */
public class SupplierTest {
    @Test
    public void test() {
        Supplier<Car> carSupplier = Car::new;
        Car car = carSupplier.get();
        assertTrue(Objects.nonNull(car));
    }
}
