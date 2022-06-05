// Ссылка на обобщенный метод экземпляра
// 1. Обобщенный (шаблонный) функциональный интерфейс
interface IFuncArray<T extends Number> {
    // Метод, получающий массив типа T и возвращающий тип double
    double FuncArray(T[] array);
}

// 2. Класс, содержащий методы обработки массивов
class ProcessWithArray<T extends Number> {
    // Сумма элементов массиву
    double Sum(T[] array) {
        double sum = 0;
        for (T value : array)
            sum += value.doubleValue();
        return sum;
    }

    // Среднее арифметическое элементов массива
    double Avg(T[] array) {
        double avg = 0;
        for (T value : array)
            avg += value.doubleValue();
        return avg/array.length;
    }
}

// 3. Класс, который содержит шаблонный метод,
//   получающий ссылку на метод экземпляра
class ClassOperation {

    <T extends Number> double Operation(IFuncArray<T> ref, T[] array) {
        // вызвать метод интерфейса IFuncArray
        double result = ref.FuncArray(array);
        return result;
    }
}

// 4. Класс, который демонстрирует ссылку на метод экземпляра
public class RefMethod {

    public static void main(String[] args) {
        // 1. Объявить экземпляр класса ClassOperation
        ClassOperation Op = new ClassOperation();

        // 2. Объявить экземпляр класса ProcessArray<T>
        ProcessWithArray<Integer> processWithArray = new ProcessWithArray<>();

        // 3. Подготовить массив целых чисел для обработки и вывести его
        Integer[] AI = { 2, 4, 8, -1, 3, -5 };
        System.out.print("AI = ");
        for (int t : AI)
            System.out.print(t + " ");
        System.out.println();

        // 4. Вычислить среднее арифметическое массива AI,
        //    передавая метод processWithArray.Avg() в метод Op.Operation()
        double average = Op.Operation(processWithArray::Avg, AI);
        System.out.println("average = " + average);

        // 5. Вычислить сумму элементов массива AI.
        //     Для этого нужно передать метод processWithArray.Sum() в Op.Operation()
        double sum = Op.Operation(processWithArray::Sum, AI);
        System.out.println("sum = " + sum);
    }
}
