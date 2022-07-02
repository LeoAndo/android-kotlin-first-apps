package sample13;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public final String getName() {
        return this.name;
    }

    public final int getAge() {
        return this.age;
    }

}