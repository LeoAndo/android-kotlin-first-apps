package sample13

fun main() {
    val person: Person = MainCharacter("yamada", 20)
    if (person is MainCharacter) {
        print(person.greeting)
    }
}

open class Person(val name: String, val age: Int)
class MainCharacter(name: String, age: Int) : Person(name, age) {
    val greeting = "Hello, $name"
}

class SubCharacter(name: String, age: Int) : Person(name, age) {
    val address = "Tokyo"
}