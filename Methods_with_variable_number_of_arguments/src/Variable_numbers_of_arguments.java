// Использование массива аргументов переменной длины
// наряду с обычными аргументами

public class Variable_numbers_of_arguments {

    static void variableArgsTest(int n, String message, int... var_args){ // Переменное число аргументов указывается последним и единственным в списке аргументов метода
        System.out.println(n + message + var_args.length);// Функция .length определяет длину переданного массива переменных аргументов
        System.out.println("Содержимое: ");

        for(int i = 0; i < var_args.length; i++) {
            System.out.println(" argument " + i + ": " + var_args[i]);// Доступ к аргументу переменного числа аргументов как к обычному массиву по индексу
        }

    }

    public static void main(String[] args){
        variableArgsTest(1," Один аргумент в массиве: ", 10);
        variableArgsTest(2," Пять аргументов в массиве: ", 1, 2, 3, 220, 777);
        variableArgsTest(3," Отсутствуют аргументы в виде массива: ");

    }
}
