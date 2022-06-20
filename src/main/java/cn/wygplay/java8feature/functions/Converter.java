package cn.wygplay.java8feature.functions;

/**
 * @FunctionalInterface 注解修饰的接口只能包含一个抽象方法（可以有多个默认方法、静态方法）
 * 用于标识函数式接口
 * 没有注解修饰时，功能依然生效
 * @author wyg
 * @date 2022/6/19 17:52
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
    // 只能包含一个抽象方法
    //void test();
}
