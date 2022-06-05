import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:/SerialObject2"));
        ObjectOutputStream oos = new ObjectOutputStream(bos); // Сериализация осуществляется путем ObjectOutputStream
        oos.writeObject(new SerialClass());
        oos.close();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:/SerialObject2"));
        ObjectInputStream ois = new ObjectInputStream(bis);
        SerialClass scObject = (SerialClass) ois.readObject();
        System.out.println(scObject.resultString);
        System.out.println(scObject.resultString2);
        ois.close();

        File file = new File("\"D:/SerialObject2\"");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());


    }
}

class SerialClass implements Serializable { //Маркерный интерфейс, говорящий Java о возможности сериализовать объект класса
    public static final long serialVersionUID = 777L; //Это поле задаёт уникальный идентификатор сериализованного объекта
    public transient String resultString2 = "ПРОПУСК"; //Это поле не будет сериализовано
    private SerialClass2 sc2 = new SerialClass2("БАРС");
    public String resultString = sc2.getName();
}

class SerialClass2 implements Serializable { //Все связанные объекты тоже должны быть Serializable
    private String name;

    SerialClass2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
