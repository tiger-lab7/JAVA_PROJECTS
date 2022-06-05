import java.util.Arrays;

public class AutoboxingTest {
    private final static int TEST_SIZE_BEGIN = 10;
    private final static int TEST_SIZE = 1280;

    public static void main(String[] args) {
        System.out.println("Testing primitive ints stack!");
        doublingTest(TEST_SIZE_BEGIN, TEST_SIZE);
        System.out.println("Testing generics Integer stack!");
        doublingTest2(TEST_SIZE_BEGIN, TEST_SIZE);
    }

    private static void doublingTest(int testSizeBegin, int testSizeEnd) {
        for(int t = testSizeBegin; t <= testSizeEnd; t *= 2){
            int[] resultArray = new int[t];
            StackInts stackInts = new StackInts();
            long begin = System.nanoTime();
            for (int i = 0; i < t; ++i) stackInts.push(i);
            for (int i = 0; i < t; ++i) resultArray[i] = stackInts.pop();
            long end = System.nanoTime();
            System.out.println("Test size = " + t + " Result " + (end - begin) / 1000 + " ms");
            //System.out.println(Arrays.toString(resultArray));
        }
    }

    private static void doublingTest2(int testSizeBegin, int testSizeEnd) {
        for(int t = testSizeBegin; t <= testSizeEnd; t *= 2){
            int[] resultArray = new int[t];
            StackGenerics<Integer> stackInteger = new StackGenerics<>();
            long begin = System.nanoTime();
            for (int i = 0; i < t; ++i) stackInteger.push(i);
            for (int i = 0; i < t; ++i) resultArray[i] = stackInteger.pop();
            long end = System.nanoTime();
            System.out.println("Test size = " + t + " Result " + (end - begin) / 1000 + " ms");
            //System.out.println(Arrays.toString(resultArray));
        }
    }
}


