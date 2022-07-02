package sample12

fun main() {
    val yamada = Person("yamada", 20) // data classで定義
    val yamada2 = Person("yamada", 20) // data classで定義
    val tanaka = Person2("tanaka", 20) // classで定義
    val tanaka2 = Person2("tanaka", 20) // classで定義
    println("yamada.equals(yamada2): ${yamada.equals(yamada2)} , tanaka.equals(tanaka2): ${tanaka.equals(tanaka2)}")
    println("yamada.hashCode(): ${yamada.hashCode()} , yamada2.hashCode(): ${yamada2.hashCode()}")
    println("tanaka.hashCode(): ${tanaka.hashCode()} , tanaka2.hashCode(): ${tanaka2.hashCode()}")
    println("yamada.toString(): ${yamada.toString()} , yamada2.toString(): ${yamada2.toString()}")
    println("tanaka.toString(): ${tanaka.toString()} , tanaka2.toString(): ${tanaka2.toString()}")
    println("name: ${yamada.component1()}, age: ${yamada.component2()}")
    val copyYamada = yamada.copy(age=25)
    println("copyYamada $copyYamada")
    println("copyYamada.hashCode: ${copyYamada.hashCode()}")
}
data class Person(val name: String, val age: Int)
class Person2(val name: String, val age: Int)