import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cat cat1 = new Cat(1, "VASILIY", false);
        Cat cat2 = new Cat(2, "SNEJANKA", true);

        try (FileOutputStream fileOutputStream = new FileOutputStream("cats.obj");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(cat1);
            objectOutputStream.writeObject(cat2);
        }

        cat1 = null; cat2 = null;

        try (FileInputStream fileInputStream = new FileInputStream("cats.obj");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            cat1 = (Cat) objectInputStream.readObject();
            cat2 = (Cat) objectInputStream.readObject();
        }

        System.out.println(cat1);
        System.out.println(cat2);
    }
}

class Cat implements Serializable {
    public Cat(long id, String name, boolean sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    long id;
    String name;
    boolean sex;

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}