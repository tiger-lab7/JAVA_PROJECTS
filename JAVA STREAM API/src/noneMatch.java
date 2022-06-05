import java.util.Arrays;
import java.util.List;

// stream().noneMatch логическая функция, проверяет НЕ совпадение всех элементов стрима по лямбде типа Predicate

public class noneMatch {

    public static void main(String... args){

        List<Integer> numbers = Arrays.asList(56,68,343,23,5656,1535,32765);

        boolean match = numbers.stream().noneMatch(a -> a < 0);

        System.out.println(match);
    }
}
