import java.util.EmptyStackException;

public class StackGenerics <T> {
    private static class Node<T> {
        T val;
        StackGenerics.Node<T> next;
    }
    private StackGenerics.Node<T> firstNode;

    public void push(T input) {
        StackGenerics.Node<T> node = new StackGenerics.Node<T>(); node.val = input;
        if(firstNode == null) {
            firstNode = node;
            return;
        }
        node.next = firstNode;
        firstNode = node;
    }
    public T pop() {
        if(firstNode == null) throw new EmptyStackException();
        T result = firstNode.val;
        firstNode = firstNode.next;
        return result;
    }
}
