import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.gson.Gson;

public class GSONParsing {

    public static void main(String[] args) {

        String jsonString = "{\"name\" : \"ВАСЯ\", \"age\" : 5}";

        Gson gson = new Gson();
        Cat cat = gson.fromJson(jsonString, Cat.class);
        System.out.printf("{ Имя: %s, Возраст: %d }", cat.name, cat.age);
    }
}
@JsonAutoDetect
class Cat {
    String name;
    int age;
}
