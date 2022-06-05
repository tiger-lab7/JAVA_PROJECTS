import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String... args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("CAT BARSIK", 5);
        map.put("CAT SNEJOK", 10);
        map.put("CAT PUSHOK", 7);

        map.merge("CAT SNEJOK", 12, (mapVal, newVal) -> {
            System.out.println(mapVal);
            return mapVal + newVal;});
        printMap(map);

        map.replaceAll((key, val) -> {return val + 1;});
        printMap(map);

        map.computeIfAbsent("CAT TIGER", newKey -> 10);
        printMap(map);

        map.compute("CAT TIGER", (key, oldVal) -> {return oldVal + 777;});
        printMap(map);

        map.computeIfPresent("CAT BEGEMOT", (key, oldVal) -> {return oldVal + 20;});
        printMap(map);


    }

    private static void printMap(Map<?,?> map) {
        map.forEach((key, val) -> System.out.println(key + " " + val));
    }
}
