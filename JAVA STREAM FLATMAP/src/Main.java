
import java.util.stream.IntStream;

public class Main {

    public static void main(String... args) {

        IntStream.iterate(0, x -> ++x).limit(4)
                .flatMap(x -> IntStream.of(x * 2, x + 1, x % 2))
                .allMatch(x -> {System.out.println(x); return true;});
    }
}
