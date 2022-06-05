import java.io.*;
import java.util.Locale;

public class FileParser {

    private static final String regex = "[абвгдеёжзийклмнопрстуфхцчшщъьыэюя]";

    public static StringBuilder parseFile(File file) throws FileNotFoundException, UnsupportedEncodingException {

        //FileInputStream fileInputStream = new FileInputStream(file);

        BufferedReader input = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), "UTF-8"));

        // String encoding = fileReader.getEncoding();

        //  System.out.println("Кодировка файла: " + encoding);


        //  System.setProperty("file.encoding", encoding);

        StringBuilder bigString = new StringBuilder();

        //bigString.ensureCapacity(1000000);
        int readByte = 0;
        // int x = 0;
        char readChar = 1;
        try {
            while (input.ready()) {
                //x++;

                readChar = (char) input.read();
                // System.out.println(readChar);
                String readString = String.valueOf(readChar).toLowerCase(Locale.ROOT);
                if (readString.matches(regex)) bigString.append(readString);
                else bigString.append(" ");
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }

        System.out.println("Длина прочитанной строки " + bigString.length());

        return bigString;
    }
}
