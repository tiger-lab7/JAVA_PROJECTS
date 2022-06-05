import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SimpleJSON {

    public static void main(String[] args) {
        String jsonString = "{\"name\" : \"ВАСЯ\", \"age\" : 5}";

        try {
            Object obj = new JSONParser().parse(jsonString); // Парсим в объект при помощи JSONParser().parse()
            JSONObject jsonObject = (JSONObject) obj; // Кастуем объект к типу JSONObject
            String name = (String) jsonObject.get("name"); // Получаем объекты значений по ключу и кастуем к нужному типу
            Long age = (Long) jsonObject.get("age"); // Числовые значения получаются как объект класса Long

            System.out.printf("{ Имя: %s, Возраст: %d }", name, age);

        } catch (org.json.simple.parser.ParseException ex) {ex.printStackTrace();}
    }
}

