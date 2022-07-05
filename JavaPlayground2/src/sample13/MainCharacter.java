package sample13;

public final class MainCharacter extends Person {
    private final String greeting;

    public MainCharacter(String name, int age) {
        super(name, age);
        this.greeting = "Hello, " + name;
    }

    public String getGreeting() {
        return this.greeting;
    }
}