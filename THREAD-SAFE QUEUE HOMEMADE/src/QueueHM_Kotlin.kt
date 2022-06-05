
class QueueHMKotlin <T> {
    private class Node <T> {
        var value: T? = null
        var next: Node<T>? = null
    }

    @Volatile private var firstNode: Node<T>? = null
    private var lastNode: Node<T>? = null

    @Synchronized
    fun pushBack(input: T) {
        val node = Node<T>()
        node.value = input
        if(firstNode == null) {
            firstNode = node
            lastNode = node
            return
        }
        lastNode?.next = node
        lastNode = node
    }

    @Synchronized // Аннотация играет ту же роль, что и synchronized в Java
    fun popFront(): T? {

        //while(isEmpty()) {}

        val result = firstNode?.value
        firstNode = firstNode?.next
        return result
    }

    @Synchronized
    fun isEmpty(): Boolean {
        return firstNode == null
    }
}

fun main() {
    val queueHM = QueueHMKotlin<Int>()

    val pusher = {
        for (i in 1..20) {
            //Thread.sleep(500)
            queueHM.pushBack(i)
        }
    }
    val popper = {
        while (!queueHM.isEmpty()) {
            println(queueHM.popFront())
        }
    }

    Thread(pusher).start()
    Thread(popper).start()
}
