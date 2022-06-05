import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerialTest serialTestObject1 = new SerialTest(new StringBuilder("КОТ БАРСИК"));


        FileOutputStream outputFile = new FileOutputStream("D:/SerializableFile");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputFile);
        objectOutputStream.writeObject(serialTestObject1);
        objectOutputStream.close();


        BufferedInputStream inputFile = new BufferedInputStream(new FileInputStream("D:/SerializableFile"));

        ObjectInputStream objectInputStream = new ObjectInputStream(inputFile);

        while(objectInputStream.available() > 0) {
            SerialTest serialTest = (SerialTest) objectInputStream.readObject();
            System.out.println(serialTest.toString());
            System.out.println(serialTest.getInt());
        }
        objectInputStream.close();

    }
}

class SerialTest implements Serializable {

    private StringBuilder name;
    //private static final long serialVersionUID = 1;

    SerialTest(StringBuilder name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    public int getInt() {
        return 777;
    }

}
