import java.util.HashSet;

import java.util.Set;

public class Main1 {

    public static void main(String... args) {

        Set<Node> nodeSet = new HashSet<>(100, 0.75F);

        for(int i = 0; i < 100; i++) {
            nodeSet.add(new Node((int) (Math.random() * 10)));
        }

        nodeSet.stream()
                .map(s -> s.getData())
                .forEach(System.out::println);
    }
}

class Node {
    private int data;
    public Node(int data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }
    @Override
    public int hashCode() {
        int hashCode = data % 10;
        System.out.println("Хеш-код равен: " + hashCode);
        return hashCode;
    }
    @Override
    public boolean equals(Object other){
        System.out.println("Проверяем объекты на equals!");
        //if(!super.equals(other)) return false;
        if (this == other) return true;
        if (other == null) return false;
        if(this.getClass() != other.getClass()) return false;
        Node otherObj = (Node) other;
        return data == otherObj.getData();
    }

}
