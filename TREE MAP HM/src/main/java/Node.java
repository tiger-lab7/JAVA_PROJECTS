import java.util.Map;

public class Node <K,V> {

    public final K key;
    public V val;
    public Node<K,V> left;
    public Node<K,V> right;

    Node(K key, V val) {
        this.key = key;
        this.val = val;
    }
}


class MapEntry<K extends Comparable<K>,V> implements Map.Entry<K,V>, Comparable<MapEntry<K,V>>  {
    private final K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    @Override
    public int compareTo(MapEntry<K, V> o) {
        return key.compareTo(o.key);
    }
}

