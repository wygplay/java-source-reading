package cn.wygplay.java8feature.reference;

/**
 * 两个抽象方法
 * @author wyg
 * @date 2022/6/19 19:18
 */
public interface PersonFactory2<P extends Person> {
    P create (String firstName, String lastName);
    P rename (String firstName, String lastName);
}
