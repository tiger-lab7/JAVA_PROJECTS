import java.util.function.Function;

public class Main {

    public static void main(String... args) {

        Function<Integer, Integer> lambda1 = n -> n + 10;
        Function<Integer, Integer> lambda2 = n -> n * 100;

        Integer result = lambda1.andThen(lambda2).apply(20);

        System.out.println("andThen " + result);

        result = lambda1.compose(lambda2).apply(20);

        System.out.println("compose " + result);

        result = lambda1.andThen(lambda2).compose(lambda1).andThen(lambda1).compose(lambda2).apply(20);

        System.out.println(" " + result);

    }
}
