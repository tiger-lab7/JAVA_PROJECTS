import java.util.HashSet;
import java.util.Set;

public class HashMapHM <K, V> {

    private int buckets = 16;
    private Node[] hashArray = new Node[buckets];
    private int capacity = 10;
    private float loadFactor = 0.75F;

    public HashMapHM(int capacity, float loadFactor) {
         this.capacity = capacity;
         this.loadFactor = loadFactor;
    }

    public void put(K key, V value) throws Exception {

        if(key == null) throw new Exception("Key must not be Null!");

        Node tmpNode = new Node(key, value);
        int hashCode = tmpNode.hashCode;
        int index = hashCode & (buckets - 1);
        System.out.println("Назначен индекс:" + index);

        if(hashArray[index] == null) {
            hashArray[index] = tmpNode;
            return;
        }
        Node nodeToWright = hashArray[index];
        do {
            if(nodeToWright.equals(tmpNode)) {nodeToWright.setData(value); return;}
            if(nodeToWright.nextNode == null) {nodeToWright.nextNode = tmpNode; return;}
            else nodeToWright = nodeToWright.nextNode;
        } while(true);

    }

    public V get(K key) throws Exception {

        if(key == null) throw new Exception("Key must not be NULL!");

        int hashCode = (int) key % 10;
        int index = hashCode & (buckets - 1);

        if(hashArray[index] == null) {System.out.println("Массив пуст"); return null;}

        Node nodeToRead = hashArray[index];
        do {
            if((K)nodeToRead.key == key) return (V)nodeToRead.getData();
            nodeToRead = nodeToRead.nextNode;
        } while(nodeToRead != null);
        throw new Exception("Not found this key!");
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();

        return keySet;
    }

}


