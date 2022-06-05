public class Node <T> {
    public int hashCode;
    private T data;
    public Node nextNode;
    public Node nextCollisionNode;

    public Node(T input) {
        data = input;
        hashCode = hashCode();
    }

    public T getData() {
        return data;
    }

    @Override
    public int hashCode() {
        int hashCode = (int) data;
        //System.out.println("HashCode = " + hashCode);
        hashCode = 49;
        return hashCode;
    }


    public boolean equals1(Node checkNode) {
        if((int) checkNode.getData() == (int) data) {return true;}
        return false;
    }

}
