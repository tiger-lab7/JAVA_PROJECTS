import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Data {
    private static final String PATH = "src/main/resources/input.json";

    public static String getInputJson() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}
