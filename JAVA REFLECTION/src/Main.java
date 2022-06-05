import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Test1 test1Obj = new Test1();

        Field field = test1Obj.getClass().getDeclaredField("secretString");
        field.setAccessible(true);
        String takeString = (String) field.get(test1Obj);
        System.out.println(takeString);

        Field field2 = test1Obj.getClass().getDeclaredFields()[1]; //Получаем второе поле класса объекта
        field2.setAccessible(true); // Устанавливаем доступность поля
        int takeInt = (int) field2.get(test1Obj); // Получаем значение приватного поля и приводим к нужному типу
        System.out.println(takeInt);

        field2.set(test1Obj, (int) 777); // Устанавливаем значение приватного поля
        System.out.println((int) field2.get(test1Obj));

        Method method = test1Obj.getClass().getDeclaredMethod("secretMethod");// Получаем метод по имени
        method.setAccessible(true); // Устанавливаем доступность метода
        method.invoke(test1Obj); // Вызываем приватный метод!

    }
}

class Test1 {
    private String secretString = "КОТ ВАСИЛИЙ ОЧЕНЬ УМЁН!";
    private int secretCode = 31415926;

    private void secretMethod() {
        System.out.println("КОТ БАРСИК КРАСИВЫЙ!");
    }
}
