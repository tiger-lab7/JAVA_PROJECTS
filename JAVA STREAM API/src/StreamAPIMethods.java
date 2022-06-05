import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPIMethods {

    public static void main(String[] args) {

       Stream stream = Stream.of(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5, -1000, 777);

       //stream.sorted().forEach(System.out::println);

       //System.out.println(stream.min(Comparator.reverseOrder()).get());

        Comparator<Integer> myComparator = new Comparator<>() { //Comparator -функц. интерфейс, нужно реализовать его единственный метод compare
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        };
        // То же самое с лямбдой: Comparator<Integer> myComparator = (a, b) -> a.compareTo(b);

        Optional minValue = stream.min(myComparator);
        if (minValue.isPresent()) {
            System.out.println(minValue.get());
        } else {
            System.out.println("Nothing");
        }

        //Predicate<Integer> logik = v -> v > 500;
        //System.out.println(stream.anyMatch(logik));


    }
}






