

val words = arrayOf("trtt","trtr", "rrr", "rrr", "yyyy", "x", "x", "i", "x")

val counter: HashMap<String, Int> = hashMapOf()

fun main() {

    for(word in words) {
        counter.merge(word, 1) { oldV, _ -> oldV + 1 }
    }

    counter.forEach{ (k, v) -> println("$k $v") }


    //val t: Int = 6
    
    when(val t = randomType()) {
       is String -> println("Это строка")
        is Int -> println("Это Int")
    }
}

fun randomType(): Int {
    return 777
}