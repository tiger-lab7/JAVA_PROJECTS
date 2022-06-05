import java.util.Arrays;
import java.util.List;

// stream().anyMatch логическая функция, проверяет совпадение хотя бы одного элемента стрима по лямбде типа Predicate

public class anyMatch {

    public static void main(String... args){

        List<Integer> numbers = Arrays.asList(56,68,343,23,5656,1535,32765);

        boolean match = numbers.stream().anyMatch(a -> a % 2 == 0);

        System.out.println(match);
    }
}
