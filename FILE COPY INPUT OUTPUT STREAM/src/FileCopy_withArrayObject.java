import java.io.*;
import java.util.ArrayList;

public class FileCopy_withArrayObject {

    public static void main(String... args) throws IOException {

        FileInputStream fileInputStream =
                new FileInputStream("C:/Users/A12/Desktop/Дартс Павел. Крысиная башня - royallib.ru.rtf");
        FileOutputStream fileOutputStream =
                new FileOutputStream("C:/Users/A12/Desktop/Дартс Павел. Крысиная башня1.rtf");

        ArrayList<Integer> arrayList = new ArrayList<>();

        while (fileInputStream.available() > 0) {
           arrayList.add(fileInputStream.read());
        }

        for (int i = 0; i < arrayList.size(); i++) {
            fileOutputStream.write(arrayList.get(i));
        }

        fileInputStream.close();
        fileOutputStream.close();

    }
}