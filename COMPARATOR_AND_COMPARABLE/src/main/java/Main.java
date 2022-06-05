import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Cat Vasya = new Cat("Вася", 55);
        Cat Pushok = new Cat("Пушок", 45);

        List<Cat> catList = new ArrayList<>();
        catList.add(Vasya);
        catList.add(Pushok);

        // Интерфейс Comparator с функцией compare нужен для функции List.sort()
        catList.sort(new CatComparator());
        System.out.println(catList);

        // Интерфейс Comparable с функцией compareTo нужен для формирования TreeSet
        // Также можно передать и Comparator в конструктор TreeSet'а
        Set<Cat> catSet = new TreeSet<>(catList);
        System.out.println(catSet);

        Set<Cat> catSetR = new TreeSet<>(new CatReversedComparator());
        catSetR.addAll(catList);
        System.out.println(catSetR);

        /* Не путать Iterable, возвращающий new Iterator() с методами hasNext() и next()
        с интерфейсами Comparator и Comparable! */
        Iterator<Cat> catIterator = catList.listIterator();

    }

}

@AllArgsConstructor
@Value
class Cat implements Comparable<Cat> {
    String name;
    int length;

    @Override
    public int compareTo(Cat o) {
        return Integer.compare(this.length, o.length);
    }

    public CatComparator comparator() {
        return new CatComparator();
    }
}

class CatComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return Integer.compare(o1.getLength(), o2.getLength());
    }
}

class CatReversedComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        return ~Integer.compare(o1.getLength(), o2.getLength());
    }
}
