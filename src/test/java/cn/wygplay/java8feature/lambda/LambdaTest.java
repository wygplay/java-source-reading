package cn.wygplay.java8feature.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaTest {

    List<User> users;
    @BeforeEach
     void init() {
        users = new ArrayList<>();
        User userA = new User();
        userA.setName("A");
        userA.setAge(10);
        User userB = new User();
        userB.setName("B");
        userB.setAge(20);
        User userC = new User();
        userC.setName("A");
        userC.setAge(30);

        users.add(userA);
        users.add(userB);
        users.add(userC);
    }
    @Test
    void test() {
        BinaryOperator<Integer> binaryOperator = BinaryOperator.minBy(Integer::compareTo);
        Map<String, Integer> map = users.stream().collect(Collectors.toMap(User::getName, User::getAge, binaryOperator));
        assertEquals(10, map.get("A"));
    }

}

class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
