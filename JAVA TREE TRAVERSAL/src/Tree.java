import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;

public class Tree<T> {
    public Node<T> first;

    public void add(@NotNull Comparable<T> input) {
        Node<T> nextNode = new Node<>(input);

        if (first == null) {  // Если ещё нет первого узла, то присвоение значения и выход
            first = nextNode;
            return;
        }

        Node<T> node = first, lastExistedNode = null;

        while (node != null) {
            lastExistedNode = node; // Последний существующий узел, сохраняемый перед выходом из цикла

            int result = node.val.compareTo((T) input);
            if (result == 0) return; // Если значения совпадают, то сразу выход из метода add
            else if (result > 0) node = node.left;
            else node = node.right;
        }

        if (lastExistedNode.val.compareTo((T) input) > 0) lastExistedNode.left = nextNode;
        else lastExistedNode.right = nextNode;
    }

    /*
    public void remove(@NotNull Comparable<T> input) {

        Node<T> node = first;
        while(node != null) {
            if(input.compareTo((T) node.val) == 0)
        }
    }*/
    public Collection<T> getAll() {
        if (first == null) return null;

        Collection<T> array = new ArrayList<>();

        class Traversal {
            private void treeTraversal(Node<T> node) {
                if (node.left != null) treeTraversal(node.left);
                array.add((T) node.val);
                if (node.right != null) treeTraversal(node.right);
            }
        }
        new Traversal().treeTraversal(first);

        return array;
    }
}

class Node<T> {
    public Comparable<T> val;
    public Node<T> left;
    public Node<T> right;

    public Node(Comparable<T> val) {
        this.val = val;
    }
}
