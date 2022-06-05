import java.util.ArrayList;
import java.util.List;

public class HashSetHM <T> {

    private List<Integer> hashCodeStorage = new ArrayList<>();
    private Node firstNode;
    private Node lastNode;
    private Node outputNode;
    private Node lastNonCollisionNode;

    public HashSetHM() {
        firstNode = new Node<>(0);
        lastNode = firstNode;
        outputNode = lastNode;
    }

    public void add(T input) throws Exception {

        if (input == null) {throw new Exception("INPUT IS NULL!");}

        Node<T> currentNode = new Node<>(input);

        Node tmpNode = firstNode;

        while (tmpNode.nextNode != null){

            if(currentNode.hashCode == tmpNode.hashCode) {

                if (currentNode.equals1(tmpNode)) return;

                if(tmpNode.nextCollisionNode == null){
                    tmpNode.nextCollisionNode = currentNode;
                    return;
                }
                else
                {

                    Node tmpCollisionNode = tmpNode.nextCollisionNode;
                    boolean checker = true;
                    Node localTempCollisionNode;
                    do {
                        if (tmpCollisionNode.equals1(currentNode)) checker = false;
                        localTempCollisionNode = tmpCollisionNode;
                        tmpCollisionNode = tmpCollisionNode.nextCollisionNode;

                    } while (tmpCollisionNode != null);

                    if(checker) {
                        localTempCollisionNode.nextCollisionNode = currentNode;
                        return;
                    }

                }
            }
            tmpNode = tmpNode.nextNode;
        }

        lastNode.nextNode = currentNode;
        lastNode = currentNode;

        }


        public T get() throws Exception {
        Node tmpNode = outputNode;

        if(outputNode.nextNode == null) throw new Exception("NO MORE NEXT VALUES IN THE HASH SET!");
        if(outputNode == firstNode) {outputNode = firstNode.nextNode; tmpNode = outputNode;}

        if(lastNonCollisionNode != null) outputNode = lastNonCollisionNode;
        if (outputNode.nextCollisionNode == null) outputNode = outputNode.nextNode;
        else {lastNonCollisionNode = outputNode;
            outputNode = outputNode.nextCollisionNode;}

        return (T) tmpNode.getData();
        }
    }




