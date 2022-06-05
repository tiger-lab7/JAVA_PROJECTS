import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reduce {

    public static void main(String[] args) {

        //Stream допускает вызов только одной терминальной операции
        Stream<Integer> numberStream = Stream.of(1,2,3,4,5,6,7,8,9,10,11);
        // Поэтому создаем промежуточный список и коллекционируем в него поток
        // Коллектор - это преобразователь потока в другой тип данных
        List<Integer> tempList = numberStream.collect(Collectors.toList());
        Stream<Integer> numberStream1 = tempList.stream(); //Затем делаем 2 Stream'a из временного List'a
        Stream<Integer> numberStream2 = tempList.stream();

        numberStream1.forEach(System.out::println);
        // forEach ничего не возвращает, проходит переданным методом по всему стриму, терминальный

        Optional<Integer> result = numberStream2.reduce((a, b) -> a * b); // Функция - аккумулятор (a), лямбда, терминальная
        // Метод reduce возвращает тип Optional (который может быть null)

        System.out.println(result.get() + " " + result.orElse(1000)); // Получение из Optional посредством get

    }
}
