package cn.wygplay.java8feature.reference;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    @Test
    @DisplayName("测试构造函数引用")
    public void testConstructorReference() {
        // 自动选择了两个参数的构造函数
        PersonFactory<Person> personFactory = Person::new;
        PersonFactory<Person> personFactory2 = (firstName, lastName) -> new Person(firstName, lastName);
        Person person1 = personFactory.create("zhang", "san");
        Person person2 = personFactory2.create("zhang", "san");
        assertEquals(person1, person2);
    }

    @Test
    public void testConstructorReference2() {
        // 注意只能用在功能函数接口
        //PersonFactory2<Person> personFactory2 = Person::new;
    }
}