package sample13;

public class App {
    public static void main(String[] args) {
        final Person person = new MainCharacter("yamada", 20);
        if (person instanceof MainCharacter) {
            final MainCharacter mainCharacter = (MainCharacter) person;
            System.out.println(mainCharacter.getGreeting());
        }
    }
}