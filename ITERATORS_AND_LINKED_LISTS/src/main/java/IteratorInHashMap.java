import java.util.*;

public class IteratorInHashMap {
    private static final int mapSize = 100;

    public static void main(String[] args) {

        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0 ; i < mapSize; i++) {
            hashMap.put(i, i);
        }

        int[] resultArray = new int[100];


        // Map.get()
        long beginTime = System.nanoTime();

        for(int i = 0 ; i < mapSize; i++)
            resultArray[i] = hashMap.get(i);

        long endTime = System.nanoTime();

        System.out.println("Map.get() method time: "
                + (endTime - beginTime) / 1000
                + " ms. " + Arrays.toString(resultArray));


        // Using iterator.next()
        Iterator<Integer> hashMapIterator = hashMap.values().iterator();

        beginTime = System.nanoTime();

        for(int i = 0 ; i < mapSize; i++)
            resultArray[i] = hashMapIterator.next();

        endTime = System.nanoTime();

        System.out.println("Using iterator.next() method time: "
                + (endTime - beginTime) / 1000
                + " ms. " + Arrays.toString(resultArray));
    }
}
