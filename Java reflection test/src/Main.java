import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Test testObj = new Test();

        Field[] fieldArray = testObj.getClass().getDeclaredFields(); // Получаем массив всех полей

        Arrays.stream(fieldArray).forEach(System.out::println);

        Field field = fieldArray[0]; // Выбираем из массива нужное поле

        field.setAccessible(true); // Устанваливаем доступность поля методом .getAccessible(boolean)

        String hackField = (String) field.get(testObj); //Получаем поле в виде Object и преобразуем его к String

        System.out.println(hackField);

        field.set(testObj, "Я хакнул твой класс!"); // Устанавливаем новое значение приватного поля

        testObj.getMessaage(); // Проверяем как сработало!
    }
}

class Test {
    private String secretMessage = "Это секретное сообщение!";

    public void getMessaage() {
        System.out.println(secretMessage);
    }
}
