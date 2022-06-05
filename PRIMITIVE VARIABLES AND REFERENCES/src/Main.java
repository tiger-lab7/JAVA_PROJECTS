import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {



        double a = 1.0E+10D;
        double b = a; // Здесь происходит копирование значения в b
        b = 20.1D;
        System.out.println(a);


        List<String> arrayList = new ArrayList<>();
        arrayList.add("ВАСЯ");

        List<String> arrayList2 = arrayList;// А здесь - простая передча ссылки на тот же самый объект arrayList

        arrayList2.add("БАРСИК");

        arrayList.forEach(System.out::println);

        Integer int1 = 1010;
        Integer int2 = int1;
        int2 = 8080;
        System.out.println(int1);

    }
}
