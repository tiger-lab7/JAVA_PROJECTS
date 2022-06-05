

fun main() {
    val incrementer = Incrementer()
    val callIncrement = {
        while(true) {
            incrementer.increment()
        }}
    Thread(callIncrement).start()
    Thread(callIncrement).start()
}