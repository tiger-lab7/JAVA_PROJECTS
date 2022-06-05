import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MapObjectSerializator {

    public static void main(String... args) throws IOException, ClassNotFoundException {

        List<Node> nodeList = new ArrayList<>(100);

        for (int i = 0; i < 100; i++) {
            nodeList.add(new Node(java.lang.Math.random() * 1000_000));
        }

        String fileName = "D:/ObjectStream.dat";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

       for(Node node : nodeList) {
           objectOutputStream.writeObject(node);
       }

       objectOutputStream.close();

       ObjectInputStream objectInputStream =
               new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        while(true) {
            try {
                Node tmpNode = (Node) objectInputStream.readObject();
                System.out.println(tmpNode.getNumber());
            } catch (EOFException ex) {
                System.out.println("Конец чтения");
                objectInputStream.close();
                break;
            }
        }

    }
}

class Node implements Serializable {

    private double randomNumber;
    static final long serialVersionUID = 7654321L;

    public Node(double randomNumber) {
        this.randomNumber = randomNumber;
    }
    public double getNumber() {
        return randomNumber;
    }
}
