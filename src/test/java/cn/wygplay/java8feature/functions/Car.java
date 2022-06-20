package cn.wygplay.java8feature.functions;

import java.util.Objects;

/**
 * @author wyg
 * @date 2022/6/19 21:35
 */
public class Car {
    private String name;

    public Car() {}
    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Car getCar(String name) {
        Car car = new Car();
        car.setName(name);
        return car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
