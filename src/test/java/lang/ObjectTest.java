package lang;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectTest {

    @Test
    void getClassTest() {
        Person person = new Person();
        Person student = new Student();
        assertEquals("lang.Person", person.getClass().getName());
        assertEquals("lang.Student", student.getClass().getName());
    }

    @Test
    void hashCodeTest() {
        Person person = new Person(1, "w");
        Person person1 = new Person(1, "w");
        assertEquals(person.hashCode(), person1.hashCode());
    }

    @Test
    void cloneTest() throws CloneNotSupportedException {
        Person person = new Person(1, "Smith");
        Person clonedPerson = person.clone();
        assertEquals(person, clonedPerson);
        assertEquals("Smith", clonedPerson.getName());
    }

    @Test
    void waitTest() throws InterruptedException {
        Object lock = new Object();
        Thread threadA = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                synchronized (lock) {
                    try {
                        System.out.println(i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 2; i < 11; i += 2) {
                synchronized (lock) {
                    try {
                        lock.wait();
                        System.out.println(i);
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadB.start();
        threadA.start();
        threadA.join();
        threadB.join();
    }
}

class Person implements Cloneable {

    private int id;
    private String name;

    public Person() {

    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    protected Person clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        return person;
    }
}

class Student extends Person {

    private int score;
}