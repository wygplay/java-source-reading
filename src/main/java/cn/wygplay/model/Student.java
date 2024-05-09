package cn.wygplay.model;

/**
 * @author wyg
 * @date 2023/2/3 10:28
 */
public class Student implements Person{

    @Override
    public void say() {
        System.out.println("I'm a student");
    }
}
