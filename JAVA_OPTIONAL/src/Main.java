import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class Main {


    public static void main(String... args) {

        OptionalInt optionalInt = OptionalInt.of(777);
        OptionalDouble optionalDouble = OptionalDouble.of(678.877);
        OptionalDouble optionalDouble1 = OptionalDouble.empty();
        OptionalLong optionalLong = OptionalLong.of(8000L);

        // Если есть значение в Optional, то выполняет с ним IntConsumer лямбду,
        // иначе выполняет вторую Runnable лямбду без аргументов
        optionalInt.ifPresentOrElse(x -> System.out.println(x), () -> System.out.println("No int"));

        // Метод получает значение, если нет - выбрасывает исключение "NoSuchElementException"
        System.out.println(optionalLong.orElseThrow());

        try {
            // Метод получает значение, иначе выполняет лямбду, которая должна вернуть кастомное исключение
            optionalDouble1.orElseThrow(() -> new RuntimeException("Нет такого значения"));
        } catch(RuntimeException ex) {ex.printStackTrace();}

        // Выполняет лямбду Consumer, если значение есть, иначе - лямбду типа Runnable без аргументов
        optionalDouble1.ifPresentOrElse(System.out::println, () -> System.out.println("No double"));



        Optional<String> optionalString = Optional.of("CAT");

        // Выполняет лямбду типа Consumer, если значение представлено
        optionalString.ifPresent(System.out::println);

        Optional<String> mayBeEmptyOptionalString = Optional.ofNullable(randomAnswer());

        String out = mayBeEmptyOptionalString
                // Если есть значение, то передает его в качестве параметра в лямбду,
                // которая должна вернуть новый Optional
                .flatMap(result -> Optional.of("Get " + result))
                // Если есть значение и оно соответствует лямбде типа Predicate,
                // то передает его дальше, иначе возвращает empty Optional
                .filter(x -> x.matches("G.+!"))
                // Метод возвр. рез-тат лямбды типа Supplier, ЕСЛИ НЕТ значения в исходном Optional
                .orElseGet(() -> "No value");
        System.out.println(out);
    }

    static String randomAnswer() {
        return Math.random() < 0.5 ? "Answer!" : null;
    }
}
