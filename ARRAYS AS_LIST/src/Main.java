import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 5, 10);
        integerList.sort(Comparator.reverseOrder());
        //integerList.remove(1);
        System.out.println(integerList);

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(34);
        linkedList.add(88);
        System.out.println(linkedList);

        for (Object obj : linkedList) {
            System.out.println((int)obj);
        }

    }
}
