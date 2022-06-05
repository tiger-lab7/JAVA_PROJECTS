import java.util.*;

public class Main {

    public static void main(String[] args) {
        // asList не имеет автобоксинга, поэтому массив должен быть Integer, а не int
        Integer[] intData = { 1, 5, 6, 7, 88, 0 };
        // Метод класса Arrays.asList возвращает представление - List на исходный примитивный массив
        List<Integer> data = new ArrayList<>(Arrays.asList(intData));

        ListIterator<Integer> dataIterator = data.listIterator();

        // Прямой проход по упорядоченной последовательности
        while(dataIterator.hasNext()) {
            int n = dataIterator.next();
            System.out.println(n);
            // Удаление элементов не приводит к ошибкам
            // (Удаляется только тот элемент, который был получен последним вызовом next)
            if(n == 1 || n == 88) dataIterator.remove();
        }
        System.out.println(data);

        // Обратный проход по упорядоченной последовательности List посредством ListIterator.previous()
        while(dataIterator.hasPrevious()) {
            int n = dataIterator.previous();
            System.out.println(n);
            // Итератор может добавлять элемент "перед собой" в обр. направлении
            if(n == 7) dataIterator.add(999);
        }
        System.out.println(data);
    }
}
