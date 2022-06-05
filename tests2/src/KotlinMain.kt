
class KotlinMain {
}


open class Test <T> : Comparable<T> {

    var k: Int = 0;

    override fun compareTo(other: T): Int {

        if (other.k > this.k) return -1
        if (other.k < this.k) return 1
        return 0
    }



}

open class Test0 {

}

class Test1 <T> : Test<T>() {

}

fun main() {
    val forKotlin = ForKotlin()
    println(forKotlin.n)

    val forKotlin0 = Main.ForKotlin0()
    println(forKotlin0.n)
}