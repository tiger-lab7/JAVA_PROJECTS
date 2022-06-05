import java.util.Iterator;
import java.util.function.Consumer;

public class IterableLinkedList <E> implements Iterable<E> {
    public Node<E> firstNode, currentNode;

    public void add(E input) {
        Node<E> node = new Node<>();
        node.value = input;

        if(firstNode == null) { firstNode = node; currentNode = node; return;}

        currentNode.next = node; currentNode = node;
    }
    // # 1
    public IterableLinkedListIterator<E> iterator() {
        return new IterableLinkedListIterator<E>(firstNode);
    }
    // # 2
    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }
}

class IterableLinkedListIterator <E> implements Iterator<E> {
    private Node<E> node;

    IterableLinkedListIterator(Node<E> firstNode) {
        node = firstNode;
    }

    @Override
    public boolean hasNext() {
        return node.next != null;
    }

    @Override
    public E next() {
        Node<E> currentNode = node;
        node = node.next;
        return currentNode.value;
    }
}


