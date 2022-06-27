import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class GsonTypeToken {

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();

        Type type = new TypeToken<Map<String, Cat>>(){}.getType();
        Map<String, Cat> catList = gson.fromJson(Data.getInputJson(), type);

        catList.forEach((name, cat) -> System.out.println(name + " " + cat));
    }
}
