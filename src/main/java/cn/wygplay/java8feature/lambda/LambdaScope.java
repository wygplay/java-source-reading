package cn.wygplay.java8feature.lambda;

/**
 * lambda 域访问
 * @author wyg
 * @date 2022/6/19 17:26
 */
public class LambdaScope {
    static int factor = 2;

    LambdaScope() {}

    public int doubleNum(int number) {
        Formula formula = num -> factor * number;
        return formula.compute(number);
    }

    public int threeTimes(int number) {
        int f = 3;
        Formula formula = num -> f * number;
        return formula.compute(number);
    }

    public int sqrt(int number) {
        Formula formula = num -> num;
        // 不能通过lambda表达式直接访问
        return formula.sqrt(number);
    }
}
