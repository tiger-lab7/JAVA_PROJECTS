import java.util.Iterator;

public class QueueHM <T> implements Iterable<T> {

    private static class Node <T> {
        T val;
        Node<T> next;
    }

    public Node<T> firstNode, lastNode;

    public synchronized void pushBack(T input) {
        Node<T> node = new Node<>();
        node.val = input;

        if(firstNode == null) {
            firstNode = node;
            lastNode = node;
            // Уведомление потоков ожидающих на мониторе этого объекта о поступлении элемента для popFront
            this.notifyAll();
            return;
        }
        lastNode.next = node;
        lastNode = node;
    }

    public synchronized T popFront() {
        // Луп ожидания пополнения очереди
       // while(isEmpty()) {
           // try {
            //    this.wait(); // Ожидание на мониторе этого объекта
           // } catch (InterruptedException ignored) {}
      //  }

        T result = firstNode.val;
        firstNode = firstNode.next;
        return result;
    }

    public synchronized boolean isEmpty() {
        return firstNode == null;
    }


    public Iterator<T> iterator() {

        class IteratorQueueHM implements Iterator<T> {
            private Node<T> node = firstNode;
            public boolean hasNext() {
                return node != null;
            }
            public T next() {
                T result = node.val;
                node = node.next;
                return result;
            }
        }
        return new IteratorQueueHM();
    }
}
