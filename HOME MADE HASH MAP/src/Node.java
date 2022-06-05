class Node <K, V> {

    public K key;
    private V data;
    public int hashCode;
    public Node nextNode;

    public Node(K key, V data) {
        this.key = key;
        this.data = data;
        hashCode = hashCode();
        System.out.println("Создано ядро. Ключ: " +
                key + " Данные:" + data + " hashCode: " + hashCode);
    }

    @Override
    public int hashCode() {

        int hashCode = (int) key % 10;
        return hashCode;//TODO: подумать над вычислением через поток байт
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Node testObj = (Node) obj;
        return key == (K) testObj.key;
    }

    public V getData() {
        return data;
    }
    public void setData(V value) {
        this.data = value;
    }
}