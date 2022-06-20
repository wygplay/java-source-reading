package cn.wygplay.java8feature.lambda;

/**
 * @author wyg
 * @date 2022/6/19 20:10
 */
@FunctionalInterface
public interface Formula {
    int compute(int number);

    default int sqrt(int number) {
        return number * number;
    }
}
