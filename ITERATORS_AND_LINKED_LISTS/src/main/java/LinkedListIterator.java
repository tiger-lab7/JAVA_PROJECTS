import java.util.*;
import java.util.stream.IntStream;

public class LinkedListIterator {
    private static final Random random = new Random();
    private static final int listSize = 100;

    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList<>();
        //List<Integer> linkedList = new ArrayList<>();
        IntStream.range(0, listSize).forEach(n -> linkedList.add(random.nextInt(100)));

        int[] resultArray = new int[100];


        // Collections.get()
        long beginTime = System.nanoTime();

        for(int i = 0 ; i < listSize; i++)
            resultArray[i] = linkedList.get(i);

        long endTime = System.nanoTime();

        System.out.println("Collections.get() method time: "
                + (endTime - beginTime) / 1000
                + " ms. " + Arrays.toString(resultArray));


        // Using iterator.next()
        Iterator<Integer> linkedListIterator = linkedList.listIterator();

        beginTime = System.nanoTime();

        for(int i = 0 ; i < listSize; i++)
            resultArray[i] = linkedListIterator.next();

        endTime = System.nanoTime();

        System.out.println("Using iterator.next() method time: "
                + (endTime - beginTime) / 1000
                + " ms. " + Arrays.toString(resultArray));

    }
}
