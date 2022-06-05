import java.io.*;
import java.util.Arrays;

public class Main {
    private static final Cat[] catNames = {
            new Cat(1, "Барсик"),
            new Cat(2, "Снежок"),
            new Cat(3, "Пушок")
    };
    private static final String pathToSave = "C:/Users/A12/Desktop/Serial.file";

    public static void main(String... args) {
        writeSerialObject(pathToSave);
        readSerialObject(pathToSave);
    }

    private static void writeSerialObject(String path) {
        try {
            BufferedOutputStream bufferedOutputStream =
                    new BufferedOutputStream(new FileOutputStream(path));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            objectOutputStream.writeObject(catNames);
            objectOutputStream.flush(); // Принудительная запись, заполняем буфер, заставляя его сбросить порцию в файл
            objectOutputStream.close();

        } catch (java.io.IOException ex) { ex.printStackTrace(); }
    }

    private static void readSerialObject(String path) {
        try {
            BufferedInputStream bufferedInputStream =
                    new BufferedInputStream(new FileInputStream(path));
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

            Cat[] cats = (Cat[]) objectInputStream.readObject(); // Читаем 1 объект - массив целиком

            objectInputStream.close();

            // Не обязательно создавать стрим из примитивного массива методом Arrays.stream(),
            // быстрее будет использовать view - перобразование Arrays.asList!
            Arrays.asList(cats).forEach(cat -> System.out.println(cat.toString()));

        } catch (IOException | ClassNotFoundException ex) { ex.printStackTrace(); }
    }
}

class Cat implements Serializable { // Маркерный интерфейс, ни к чему не обязывает
    @Serial
    private static final long serialVersionUID = 6768768698L; // Ключ для шифрования serial объектов
    private final int number;
    private final String name;
    private transient int randomId = (int) (Math.random() * 10);

    public Cat(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", randomId=" + randomId +
                '}';
    }
}
