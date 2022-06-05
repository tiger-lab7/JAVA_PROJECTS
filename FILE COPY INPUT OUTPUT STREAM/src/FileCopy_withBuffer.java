import java.io.*;

public class FileCopy_withBuffer {

    public static void main(String... args) throws IOException {

        FileInputStream fileInputStream =
                new FileInputStream("C:/Users/A12/Desktop/Дартс Павел. Крысиная башня - royallib.ru.rtf");
        FileOutputStream fileOutputStream =
                new FileOutputStream("C:/Users/A12/Desktop/Дартс Павел. Крысиная башня1.rtf");
        /*
        Создаем буферные потоки для чтения и записи файла буферизованными блоками,
         без постоянного обращения к диску
        */
        BufferedInputStream bufferIn = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferOut = new BufferedOutputStream(fileOutputStream);


        while (bufferIn.available() > 0) {
            int data = bufferIn.read();
            bufferOut.write(data);
        }


        fileInputStream.close();
        fileOutputStream.close();

    }
}
