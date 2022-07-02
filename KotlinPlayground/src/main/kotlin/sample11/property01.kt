package sample11

class Foo {
    var counter = 0
        set(value) {
            println("setが呼ばれる: $value")
            if (value >= 0) {
                field = value
            }
        }
        get() {
            val randomValue = listOf(5, 10, 15, 20).random()
            println("getが呼ばれる： $randomValue")
            return field + randomValue
        }
}

fun main() {
    val foo = Foo()
    foo.counter = -1
    println(foo.counter)
    foo.counter = 10
    println(foo.counter)
}