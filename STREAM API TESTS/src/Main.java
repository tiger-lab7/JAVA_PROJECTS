import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Animal> animals = List.of(
                new Animal("Tiger", 14, Classification.PREDATOR),
                new Animal("Cow", 7, Classification.HERBIVORE),
                new Animal("Bobcat", 2, Classification.PREDATOR),
                new Animal("T-Rex", 25, Classification.CARNIVORE),
                new Animal("Turtle", 220, Classification.HERBIVORE),
                new Animal("Bear", 10, Classification.OMNIVORE),
                new Animal("Wolf", 10, Classification.PREDATOR)
        );

        // Filter
        List<Animal> filtredList = animals
                .stream()
                .filter(anim -> anim.getClassification().equals(Classification.PREDATOR))
                .toList();
        //filtredList.forEach(System.out::println);

        // Sort
        List<Animal> sortedList = animals
                .stream()
                .sorted(Comparator
                        .comparingInt(Animal::getAge) // Передача метода идет от названия класса
                        .reversed()
                        .thenComparing(Animal::getClassification)) // Порядок определяется порядком расположения констант enum
                .toList();
       // sortedList.forEach(System.out::println);

        // Min
        Optional<Integer> minAge = animals
                .stream()
                .min(Comparator.comparingInt(Animal::getAge))
                .map(Animal::getAge);
       // minAge.ifPresent(System.out::println);

        // Max
        Optional<Integer> maxAge = animals
                .stream()
                .max(Comparator.comparingInt(Animal::getAge))
                .map(Animal::getAge);
       // maxAge.ifPresent(System.out::println);

        // anyMatch
        Boolean hasOldestThen = animals
                .stream()
                .anyMatch(anim -> anim.getAge() > 100);
        //System.out.println(hasOldestThen);

        // allMatch
        Boolean allAPredators = animals
                .stream()
                .allMatch(anim -> anim.getClassification().equals(Classification.PREDATOR));
       // System.out.println(allAPredators);

        // noneMatch
        Boolean hasAge = animals
                .stream()
                .noneMatch(anim -> anim.getAge() == 11);
        //System.out.println(hasAge);

        // Grouping by
        Map<Classification, List<Animal>> groupAnimals = animals
                .stream()
                .collect(Collectors.groupingBy(Animal::getClassification));

        groupAnimals.forEach(
                (k, v) -> {
                    System.out.println(k);
                    v.forEach(System.out::println);
                }
        );

    }
}
