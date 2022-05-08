package jp.ac.jec.cm0199.counterapp;

public class Counter {
    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public void countUp() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
