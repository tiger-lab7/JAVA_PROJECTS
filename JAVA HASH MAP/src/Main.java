import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("Первый", "Кот Вася");

        hashMap.put("Второй", "Кот Вася");

        hashMap.put("Третий", "Кот Барсик");

        System.out.println(hashMap.size()); // Получаем количество элементов
        System.out.println(hashMap.containsKey("Второй")); //Проверяем существование ключа
        System.out.println(hashMap.containsValue("Кот Барсик")); //Проверяем существование значения

        for(String key : hashMap.keySet()) { // Проходим по всем ключам keySet()
            System.out.println("KEY: " + key);
        }

        for(String value : hashMap.values()) { // Проходим по всем значениям values
            System.out.println("VALUE: " + value);
        }

        for(Map.Entry mapEntry : hashMap.entrySet()){ // Проходим по всем содержимому
            System.out.println("KEY:  " + mapEntry.getKey() + " VALUE: " + mapEntry.getValue());
        }

        System.out.println(hashMap.get("Первый")); // Получаем значение по ключу
        System.out.println(hashMap.compute("Первый", (a, b) -> b.toLowerCase()));
        //В HashMap.compute есть встроенная лямбда BiFunction из 2-х параметров!
        System.out.println(hashMap.get("Первый"));


    }
}
