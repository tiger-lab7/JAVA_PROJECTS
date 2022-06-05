import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CounterHashMap {

    public static void main(String[] args) {

        String[] wordList = {"trtt","trtr", "rrr", "rrr", "yyyy", "x", "x", "i", "x"};

        HashMap<String, Integer> counter = new HashMap<>();
        for(String word : wordList) {
            // 1-й вариант
            //if(counter.containsKey(word)) counter.compute(word, (k, v) -> ++v );
            //else counter.put(word, 1);
            // 2-й вариант
            //counter.put(word, counter.getOrDefault(word, 0) + 1);
            // 3-й вариант
            counter.merge(word, 1, (oldVal, newVal) -> {
                System.out.println(oldVal + " >> " + newVal);
                newVal = ++oldVal;
                return newVal; });
            // Или кратко:
            //counter.merge(word, 1, (oldVal, newVal) -> ++oldVal);
        }

        counter.forEach((k,v) -> System.out.println(k + " " + v));
    }
}
