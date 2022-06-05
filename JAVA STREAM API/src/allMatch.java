import java.util.Arrays;
import java.util.List;

// stream().allMatch логическая функция, проверяет совпадение всех элементов стрима по лямбде типа Predicate

public class allMatch {

    public static void main(String... args){

        List<Integer> numbers = Arrays.asList(56,68,3432,232,5656,15352,327652);

        boolean match = numbers.stream().allMatch(a -> a % 2 == 0);

        System.out.println(match);
    }
}