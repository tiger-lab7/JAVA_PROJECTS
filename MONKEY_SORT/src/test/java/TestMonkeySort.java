import Programm.MonkeySort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class TestMonkeySort {

    @Test
    void testMonkeySort1() {
        //int[] A = {123, 23, 241, 1, 454, 34, 0, 777, 245325, 1, 1};
        final Random random = new Random();
        int[] A = IntStream.iterate(
                0, (n) -> random.nextInt(100)).limit(12).toArray();
        System.out.println(Arrays.toString(A));
        new MonkeySort().sort(A);
        System.out.println(Arrays.toString(A));
    }

}
