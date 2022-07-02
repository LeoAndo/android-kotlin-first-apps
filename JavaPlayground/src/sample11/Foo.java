package sample11;

import java.util.*;

public final class Foo {
    private int counter;

    public int getCounter() {
        List<Integer> nums = Arrays.asList(5, 10, 15, 20);
        Collections.shuffle(nums);
        System.out.println("getが呼ばれる: " + nums);
        return this.counter + nums.get(0);
    }

    public void setCounter(int value) {
        System.out.println("setが呼ばれる: " + value);
        if (value >= 0) {
            this.counter = value;
        }
    }
}