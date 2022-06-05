import java.util.EmptyStackException;

public class StackInts {

    private static class Node {
        int val;
        Node next;
    }
    private Node firstNode;

    public void push(int input) {
        Node node = new Node(); node.val = input;
        if(firstNode == null) {
            firstNode = node;
            return;
        }
        node.next = firstNode;
        firstNode = node;
    }
    public int pop() {
        if(firstNode == null) throw new EmptyStackException();
        int result = firstNode.val;
        firstNode = firstNode.next;
        return result;
    }

}
