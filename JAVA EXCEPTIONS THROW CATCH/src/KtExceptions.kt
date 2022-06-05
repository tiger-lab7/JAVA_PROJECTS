


fun main() {
  try {
      throw RuntimeException("Это исключение!")
  } catch(ex: Exception) {ex.printStackTrace()}

    try {
        throw MyExceptionKt("Это моё исключение!", " Имеет два сообщения! ")
    } catch(ex: MyExceptionKt) {ex.printStackTrace()}

    finally {
        println("Блок finally тоже есть в Kotlin!")
    }

}

class MyExceptionKt(message: String) : Exception(message) {
    constructor(message1: String, message2: String) : this(message1) {
        System.err.print(message2)
        //println(message2)
    }
    companion object {
        init {
            println("Это объект-компаньон, замена статикам Java!")
        }
    }

}