package sample15

fun main() {
    val list = listOf("Yamada", "Tanaka")
    val result: List<String> = list.map { "$it San" }
    println(result)

    val result2: List<Person> = list.map { name -> Person(name) }
    println(result2)
}

data class Person(val name: String)

