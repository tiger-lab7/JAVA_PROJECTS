import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

import static java.lang.System.out;

class Product implements Comparable<Product> {

    private static final Comparator<Product> productComparator =
            Comparator.comparingInt((Product pr) -> pr.cost).reversed()
                    .thenComparing(pr -> pr.count)
                    .thenComparing(pr -> pr.name);
    private String name;
    private int cost;
    private long count;


    public Product(String name, int cost, long count) {
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", count=" + count +
                '}';
    }

    // #1 variant of compareTo method
    /*
    @Override
    public int compareTo(Product pr) {
        int result = Integer.compare(cost, pr.cost);
        if (result == 0) {
            result = Long.compare(count, pr.count);
        }
        if (result == 0) {
            result = String.CASE_INSENSITIVE_ORDER.compare(name, pr.name);
        }
        return result;
    }
    */
    // #2 variant of compareTo method that used static field object of Comparator
    @Override
    public int compareTo(Product pr) {
        return productComparator.compare(this, pr);
    }

}


public class Main {

    public static void main(String[] args) {
        NavigableSet<Product> productSet = new TreeSet<>();
        Random random = new Random();
        productSet.add(new Product("Листья собачьей петрушки", 112, random.nextInt(1000)));
        productSet.add(new Product("Грибы-шибальцы", 125, random.nextInt(1000)));
        productSet.add(new Product("Выдержанное вино из Туссента", 567, random.nextInt(1000)));
        productSet.add(new Product("Каэдвенский стаут", 1363, random.nextInt(1000)));
        productSet.add(new Product("Отборный мед", 567, random.nextInt(1000)));

        productSet.forEach(out::println);
    }
}


