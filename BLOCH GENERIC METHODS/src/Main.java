import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<String> set1 = Set.of("БАРСИК", "СНЕЖОК", "ПУШОК");
        Set<String> set2 = Set.of("МУРЗИК", "ВАСЯ", "ОЛИВЕР");
        Set<String> result = genericMethodUnion(set1, set2);
        result.forEach(System.out::println);


    }

    //@SuppressWarnings("unchecked")
    private static <E> Set<E> genericMethodUnion(Set<E> set1, Set<E> set2) {
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);

        return result;
    }
}


