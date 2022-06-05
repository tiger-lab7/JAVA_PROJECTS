import java.io.*;

public class FileCopy_withFileBuffered_IOStreams {

    public static void main(String... args) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new FileReader("C:/Users/A12/Desktop/Дартс Павел. Крысиная башня - royallib.ru.rtf"));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter("C:/Users/A12/Desktop/Дартс Павел. Крысиная башня1.rtf"));

        while(bufferedReader.ready()) {
            int data = bufferedReader.read();
            bufferedWriter.write(data);
        }

    }
}
