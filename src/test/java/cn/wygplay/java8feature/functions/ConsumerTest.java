package cn.wygplay.java8feature.functions;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 *
 *@author wyg
 *@date 2022/6/20 下午10:54
 */
public class ConsumerTest {
    @Test
    public void test() {
        Consumer<Car> repairingCar = (car) -> System.out.println(car.getName() + "is being repairing");
        Car car = new Car();
        car.setName("tesla");
        repairingCar.accept(car);
    }
}
