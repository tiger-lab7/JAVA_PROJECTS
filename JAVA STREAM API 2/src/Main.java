import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String... args) {
        //Создание неизменяемого списка методом Arrays.asList
        List<Person> personList = Arrays.asList(
                new Person("Вася", 7),
                new Person("Барсик", 8),
                new Person("Василёк", 8),
                new Person("Пушок", 10)
        );
        //Проверка работы метода distinct() на основе методов hashCode и equals класса
        personList.stream()
                .unordered()
                .distinct()
                .peek(s -> {
                    System.out.println(s.name + " " + s.age);
                })
                .allMatch(s -> true);

        // Собственный коллектор
        Collector<Person, StringJoiner, String> myCollector = Collector.of(
                () -> new StringJoiner(" ** "),
                (stringJoiner, person) -> stringJoiner.add("Имя: " + person.name + " -> " + person.age ),
                StringJoiner::merge,
                StringJoiner::toString
        );

        String resultCollect = personList.stream().collect(myCollector);
        System.out.println(resultCollect);

        Supplier<Stream<Person>> streamSupplier = personList.stream();
               // .filter(person -> (person.age > 8)? true : false);


        //Метод примитивов IntSummaryStatistics
        IntSummaryStatistics intSummaryStatistics = Stream.generate(Math::random)
                .limit(500L)
                .mapToInt(x -> (int) (x * 100))
                .summaryStatistics();

        System.out.println(intSummaryStatistics);

        //Создание последовательностей интов стримом IntStream.range, замена цикла
        IntStream.rangeClosed(0, 10)
                .parallel()
                .map(x -> x * 2)
                .sequential()
                .peek(System.out::println)
                .allMatch(s -> true);

    }

}

class Person {
    public String name;
    public int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;

        return true;
        //return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        //int result = name != null ? name.hashCode() : 0;
        //result = 31 * result + age;
        //return result;
        return age;
    }
}
