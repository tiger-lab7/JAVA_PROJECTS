import lombok.SneakyThrows;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Jackson {

    @SneakyThrows
    public static void main(String[] args) {

        String jsonString = "{\"name\" : \"ВАСЯ\", \"age\" : 5}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Cat cat = objectMapper.readValue(jsonString, Cat.class);

        System.out.printf("{ Имя: %s, Возраст: %d }", cat.name, cat.age);
    }
}
