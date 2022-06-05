import java.util.Arrays;

public class TestJavaOdditys {

    public static void main(String[] args) {

        System.out.println("1 + 1 = " + 1 + 1);//11 Так работает Autoboxing, переводя в строки поэлементно
        System.out.println("1 + 1 = " + (1 + 1)); // Так правильно
        System.out.println(1 + 1 + " = 2 ");


        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b); // true
        System.out.println(c <= d); // true
        System.out.println(c >= d); // true
        System.out.println(c == d); // false
        //Сравнивать объекты операторами сравнения некорректно и приводит к непредсказуемому поведению

        int[] u = {2, 3, 4,5}, v = {2, 3,4};
        // Неправильно
        System.out.println(u == v); // false Здесь идёт сравнение объектов, а не значений в массиве
        System.out.println(u.equals(v)); // false
        // Правильно
        System.out.println(Arrays.equals(u, v)); // true Значения в массиве сравниваются фабричным методом Arrays.equals
    }
}
