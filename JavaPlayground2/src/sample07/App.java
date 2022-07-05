package sample07;

public class App {
    public static void main(String[] args) {
        final Person yamada = new Person("yamada", 20);
        System.out.println(yamada.getName());
        System.out.println(yamada.getAge());
    }
}