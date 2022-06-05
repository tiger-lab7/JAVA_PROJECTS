import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> inputList = Arrays.asList(100, 200, 300, 400);

        Integer result = inputList.parallelStream()
                .map(n -> n * n)
                .reduce((n, k) -> n + k)
                .orElseThrow(RuntimeException::new);

        System.out.println(inputList);
        System.out.println(result);

    }
}


