package sample13;

public final class SubCharacter extends Person {
    private final String address;

    public SubCharacter(String name, int age) {
        super(name, age);
        this.address = "Tokyo";
    }

    public String getAddress() {
        return this.address;
    }
}