package cn.wygplay.java8feature.reference;

/**
 * @author wyg
 * @date 2022/6/19 19:14
 */
public interface PersonFactory<P extends Person> {
    P create (String firstName, String lastName);
}
