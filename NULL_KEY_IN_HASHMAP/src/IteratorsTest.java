import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorsTest {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(100);
        for(int i = 0; i < 100; i++)
            integerList.add(i);

        Runnable task = () -> {
            Iterator<Integer> integerIterator = integerList.iterator();
            while (integerIterator.hasNext())
                integerIterator.forEachRemaining(System.out::println);
        };

        new Thread(task).start();

    }
}
