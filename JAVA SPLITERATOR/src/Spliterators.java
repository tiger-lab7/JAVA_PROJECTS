import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class Spliterators {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("C","a","t"," ", "B", "a", "r", "s", "i", "k");
        Spliterator<String> spliterator = list.spliterator();

        System.out.println("Spliterator characteristics: " + spliterator.characteristics());
        System.out.println("Spliterator estimate size: " + spliterator.estimateSize());
        System.out.println("Spliterator get exact size if known: " + spliterator.getExactSizeIfKnown());
        System.out.println("Spliterator characteristics: " + spliterator.hasCharacteristics(Spliterator.SORTED));

        spliterator.tryAdvance(System.out::println);
        spliterator.tryAdvance(System.out::println);
        Spliterator<String> spliterator2 = spliterator.trySplit();
        spliterator2.forEachRemaining(System.out::println);
        spliterator.forEachRemaining(System.out::println);
        //spliterator2.forEachRemaining(System.out::println);


    }
}
