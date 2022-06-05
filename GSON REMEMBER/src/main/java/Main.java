import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    public static Logger logger = Logger.getLogger("Logger");
    private static final String filePath = "T:/JsonSave.json";

    @SneakyThrows
    public static void main(String[] args) {
        DataObject do1 = new DataObject() {
            {
                id = 1;
                name = "Igor";
                cats = new LinkedList<>(Arrays.asList("Barsik", "Snejok", "Pushok"));
                catsAge = new TreeMap<>();
                final int[] ages = {10, 7, 4};
                for (int i = 0; i <  cats.size(); i++)
                    catsAge.put(cats.get(i), ages[i]);
            }
        };

        Gson gson = new Gson();
        String serialJson = gson.toJson(do1, DataObject.class);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write(serialJson);
        bufferedWriter.flush();
        bufferedWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String jsonFromFile = bufferedReader.readLine();
        bufferedReader.close();

        logger.info("Load from json: " + jsonFromFile);

        DataObject do2 = gson.fromJson(jsonFromFile, DataObject.class);
        logger.info("Parsed object: " + do2.toString());

    }
}

@ToString
class DataObject {
    public int id;
    public String name;
    public List<String> cats;
    protected Map<String, Integer> catsAge;
}
