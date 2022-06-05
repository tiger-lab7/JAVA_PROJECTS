import java.util.*;

public class Main {
    public static void main(String... args) {

        Set<Integer> hashSet = new HashSet<>();

        long time = System.nanoTime();

        new java.util.Random();
        for(int i = 0; i < 100; i++) {
            hashSet.add((int)(Math.random() * 100));
        }

        System.out.println((System.nanoTime() - time) / 1000_000 + " milliseconds");

        System.out.println(hashSet);

        System.out.println("HASH SET содержит 10? " + hashSet.contains(10));

        hashSet.remove(10);

        System.out.println(hashSet);

        Iterator<Integer> hashSetIterator = hashSet.iterator();

        while(hashSetIterator.hasNext()) {
            System.out.println(hashSetIterator.next());
        }


        OptionalDouble average = hashSet.stream().mapToInt(Integer::intValue).average();
        System.out.println(average.getAsDouble());

        System.out.println(hashSet.size());


    }
}

