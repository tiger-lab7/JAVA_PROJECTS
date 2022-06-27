import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.IOException;

public class GsonLinkedTreeMap {

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();

        LinkedTreeMap catList = gson.fromJson(Data.getInputJson(), LinkedTreeMap.class);

        catList.forEach((name, cat) -> System.out.println(name + " " + cat));
    }
}
