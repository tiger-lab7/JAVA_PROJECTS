import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> intList =
                Arrays.stream(array).boxed().collect(Collectors.toList());
        intList = intList.subList(2, 5);
        System.out.println(intList);

        array[3] = 777;
        System.out.println(intList);

    }
}
