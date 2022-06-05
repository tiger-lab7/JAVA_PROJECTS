
fun kwargs(name: String, surname: String, color: String, age: Int = 1) {
    println("$name $surname $color $age")
}

fun main() {
    kwargs(surname = "Котофеич", name = "Кот", color = "Коричневый")
}