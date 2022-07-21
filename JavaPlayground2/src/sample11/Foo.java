package sample11;

public final class Foo {
    private int counter;

    public int getCounter() {
        System.out.println("getが呼ばれる: " + this.counter);
        return this.counter;
    }

    public void setCounter(int value) {
        System.out.println("setが呼ばれる: " + value);
        if (value >= 0) {
            this.counter = value;
        }
    }
}