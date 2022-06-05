import java.util.stream.Stream;

public class BasicStreamArrayFilter {

    public static void main(String[] args) {

        long count = Stream.of(-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5).filter(v -> v > 0).count();

        System.out.println(count);
    }
}
