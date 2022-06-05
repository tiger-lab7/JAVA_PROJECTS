import java.util.*;

public class TreeMapHM<K extends Comparable<K>, V>
        extends AbstractMap<K, V>
        implements Iterable
{
    private Node<K, V> firstNode;
    private int size = 0;
    public Set<Entry<K,V>> mapEntrySet = new TreeSet<>();

    TreeMapHM() {}

    @Override
    public V put(K key, V val) {
        Node<K, V> node = new Node<>(key, val);
        if (firstNode == null) { firstNode = node; size++; return val; }

       // Tree traversal
        Node<K,V> currentNode = firstNode;
        Node<K,V> lastExistedNode = firstNode;
        while (currentNode != null) {
            lastExistedNode = currentNode;
            int resultCompare = key.compareTo(currentNode.key);
            if (resultCompare > 0) currentNode = currentNode.right;
            else if(resultCompare < 0) currentNode = currentNode.left;
            else {
                currentNode.val = val; //Rewrite value if key existed in Tree
                return val;
            }
        }
        // Put the new Node in right or left branch of the Tree
        int resultCompare = key.compareTo(lastExistedNode.key);
        if (resultCompare > 0) lastExistedNode.right = node;
        else  lastExistedNode.left = node;
        size++;

        return val;
    }

    // Recursive centred traversal of the all Tree
    private void treeTraversal(Node<K,V> node) {
        if (node.left != null) treeTraversal(node.left);
        mapEntrySet.add(new MapEntry<>(node.key, node.val));
        if (node.right != null) treeTraversal(node.right);
    }

    // Returns the Node that contains provided key
    private Node<K,V> findNode(K key) {

        Node<K,V> node = firstNode;
        while(node != null) {
            int compareResult = node.key.compareTo(key);
            if (compareResult > 0 && node.right != null) node = node.right;
            else if(compareResult < 0 && node.left != null) node = node.left;
            else return node;
        }
        throw new RuntimeException("No such key in the map");
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return firstNode == null; }

    @Override
    public boolean containsKey(Object key) {
        try {
            findNode((K) key);
        } catch(RuntimeException ex) {return false;}
        return true;
    }

    @Override
    public boolean containsValue(Object value) {
        mapEntrySet.clear();
        treeTraversal(firstNode);
        for(Entry<K,V> mapEntry : mapEntrySet) {
            if(mapEntry.getValue().equals(value)) return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        //if(!(key instanceof this.firstNode.getClass()))

        Node<K,V> resultFindNode = findNode((K) key);
        return resultFindNode.val;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        mapEntrySet.clear();
        treeTraversal(firstNode);
        return mapEntrySet;
    }

    //@SuppressWarnings("Raw use of parameterized class")
    @Override
    public Iterator iterator() {
        class TreeMapHMIterator implements Iterator {
            final Stack<MapEntry<K,V>> mapEntryStack = new Stack<>();

            TreeMapHMIterator() {
                treeTraversal();
            }

            @Override
            public boolean hasNext() {
                return !mapEntryStack.isEmpty();
            }

            @Override
            public MapEntry<K,V> next() {
                return mapEntryStack.pop();
            }

            private void treeTraversal() {
                Node<K, V> node = firstNode;
                Stack<Node<K,V>> pathStack = new Stack<>();

                while (!pathStack.isEmpty() || node != null) {
                    if (node != null) {
                        pathStack.push(node);
                        node = node.left;
                    }
                    else {
                        node = pathStack.pop();
                        mapEntryStack.push(new MapEntry<K,V>(node.key, node.val));
                        node = node.right;
                    }
                }
            }
        }
        return new TreeMapHMIterator();
    }



}


/*
// CENTRED ITERATIVE TREE TRAVERSAL

    private Node iterativeTreeTraversalKey(K key) {

        Node node = firstNode;
        Stack<Node> pathStack = new Stack<>();

        while (!pathStack.isEmpty() || node != null) {

            if (node != null) {
                pathStack.push(node);
                node = node.left;
            } else {
                node = pathStack.pop();

                Comparable<K> comparableKey = (Comparable<K>) node.key;
                if (comparableKey.compareTo(key) == 0) {
                    System.out.println("!!!");
                    return node;
                }
                node = node.right;
            }
        }
        return null;
    }

 // CENTRED RECURSIVE TREE TRAVERSAL

    private void treeTraversalKey(K key, Node node) {
        System.out.println(node.key);

        Comparable<K> comparableKey = (Comparable<K>) node.key;
        if (comparableKey.compareTo(key) == 0) {
            System.out.println("!!!");
            resultFindNode = node;
            return;
        } else if (node.left != null) treeTraversalKey(key, node.left);
        else if (node.right != null) treeTraversalKey(key, node.right);
    }


 */