import java.io.FileWriter;
import java.io.IOException;

public class StringBuilderWriter {

    public static void writeStringBuilder(StringBuilder bigString) throws IOException {

        FileWriter fileWriter = new FileWriter("D:/DICTIONARY.txt");
        fileWriter.flush();
        for (int i = 0; i < bigString.length(); i++) {
            fileWriter.write(bigString.charAt(i));
        }
        fileWriter.close();
    }
}