import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ConcurrentModificationException {

    public static void main(String[] args) {

        List<Integer> integerList = new LinkedList<>(List.of(56, 77, 88, 99, 105));

        ListIterator<Integer> integerIterator = integerList.listIterator();

        while (integerIterator.hasNext()) {
            Integer current = integerIterator.next();
            if (current == 88) {
                integerIterator.remove();
                //integerList.add(888); // !ConcurrentModificationException!
                integerIterator.add(999); // Right: Using only the same iterator to add item
            }
        }
        System.out.println(integerList);
    }
}
