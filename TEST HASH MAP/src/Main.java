import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String... args) {

        Map<Integer, String> hashMap1 = new HashMap<>();
        hashMap1.put(111, "КОТ ВАСЯ");
        hashMap1.put(222, "КОТИК БАРСИК");
        hashMap1.put(333, "КОТИК МЯГКИЙ");
        hashMap1.put(111, "КОТИК ВАСЯ");

        for(Map.Entry entry : hashMap1.entrySet()) { //Обратить внимание на форму foreach! Интерфейс Map.Entry имя :
            System.out.println(entry);
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }

        //Как преобразовать все значения мапы в ту или иную коллекцию
        Collection<String> stringList;
        stringList = hashMap1.values(); // HashMap.values() возвращает Collection

        LinkedList<String> linkedList = new LinkedList<>(stringList); // Collection можно передать при инициализации в нужный тип коллекции

        List<String> linkedList2 = new LinkedList<>(hashMap1.values()); //Так правильно

        linkedList2.stream().forEach(System.out::println);

        // Ещё метод со Стрим АПИ, без использования конструктора List`a:
        List<String> linkedList3 =  hashMap1.values().stream().collect(Collectors.toList());
        linkedList3.stream().forEach(System.out::println);

        //Использование метода compute
        hashMap1.compute(111, (key, value1) -> value1 + " ХОРОШИЙ");
        System.out.println(hashMap1.get(111));

        //Использование метода merge:
        System.out.println(hashMap1.merge(111, "ВАСЯ", (key, value1) -> value1 + " ХОРОШИЙ"));
    }
}
