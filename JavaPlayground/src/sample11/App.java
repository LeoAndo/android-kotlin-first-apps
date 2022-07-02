package sample11;

public class App {
    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.setCounter(-1);
        System.out.println(foo.getCounter());
        foo.setCounter(10);
        System.out.println(foo.getCounter());
    }
}