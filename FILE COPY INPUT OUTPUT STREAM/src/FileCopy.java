import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    public static void main(String... args) throws IOException {

        FileInputStream fileInputStream =
                new FileInputStream("C:/Users/A12/Desktop/Дартс Павел. Крысиная башня - royallib.ru.rtf");
        FileOutputStream fileOutputStream =
                new FileOutputStream("C:/Users/A12/Desktop/Дартс Павел. Крысиная башня1.rtf");

        while (fileInputStream.available() > 0) { // .available возвращает значение int!
            int data = fileInputStream.read();  // тут тоже читаем по int
            System.out.println(Integer.toBinaryString(data)); // Так преобразуем в двоичный формат каждый int
            fileOutputStream.write(data);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
