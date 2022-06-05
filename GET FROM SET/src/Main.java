import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main {

    public static void main(String... args) {

        Set<Integer> set = new HashSet<>();

        IntStream.generate(() -> (int) (Math.random() * 100))
                .limit(50)
                .allMatch(n -> {set.add(n); return true;});

        set.forEach(System.out::println);

        set.stream()
                .filter(n -> n == 10)
                .anyMatch(n -> { System.out.println("В сете найден! " + n); return true;});

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if(iterator.next() == 10) System.out.println("Итератор! В сете найден! 10 ");
        }

        if (set.contains(10)) System.out.println("Простой метод contains! Найден 10");

    }
}
