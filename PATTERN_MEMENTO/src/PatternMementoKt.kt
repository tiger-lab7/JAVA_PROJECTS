import java.util.*

class PatternMementoKt {

    internal interface IMemento {
        val dollars: Long
        val euro: Long
    }

    internal class ExchangeMemento(override val dollars: Long, override val euro: Long) : IMemento

    internal class Exchange(d: Long, e: Long) {
        private var dollars: Long
        private var euro: Long
        fun sellDollar() {
            if (dollars > 0) --dollars
        }

        fun buyEuro() {
            ++euro
        }

        fun getDollars() {
            println("Dollars: $dollars")
        }

        fun getEuro() {
            println("Euro $euro")
        }

        fun saveState(): ExchangeMemento {
            return ExchangeMemento(dollars, euro)
        }

        fun restoreState(iMemento: IMemento) {
            dollars = iMemento.dollars
            euro = iMemento.euro
        }

        init {
            dollars = d
            euro = e
        }
    }

    internal class Memory(private var exchange: Exchange) {
        private val iMementoStack: Stack<IMemento> = Stack()
        fun backup() {
            iMementoStack.push(exchange.saveState())
        }

        fun undo() {
            if (iMementoStack.empty()) return
            exchange.restoreState(iMementoStack.pop())
        }

    }
}

fun main(args: Array<String>) {
    val exchange = PatternMementoKt.Exchange(100, 100)
    val memory = PatternMementoKt.Memory(exchange)
    exchange.getDollars()
    exchange.getEuro()
    println("-------Продаем 1 доллар. Покупаем 1 евро.-------")
    exchange.sellDollar()
    exchange.buyEuro()
    exchange.getDollars()
    exchange.getEuro()
    println("--------Сохранение состояния.--------------")
    memory.backup()
    println("-------Продаем 1 доллар. Покупаем 1 евро.-------")
    exchange.sellDollar()
    exchange.buyEuro()
    exchange.getDollars()
    exchange.getEuro()
    println("--------Восстановление состояния.--------------")
    memory.undo()
    exchange.getDollars()
    exchange.getEuro()
}
