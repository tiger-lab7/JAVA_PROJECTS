import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {

        /* Проходим Имя класса.class.методы рефлексии
           Field[] fieldArr = secretObj.getClass().getDeclaredFields();
            Или получаем класс у объекта методом getClass */
        Field[] fieldArr = SecretClass.class.getDeclaredFields();


        fieldArr[0].setAccessible(true); //Устанавливаем доступность для приватного поля
        SecretClass secretObj = new SecretClass();
        String secret = (String) fieldArr[0].get(secretObj);
        System.out.println(secret);

        String modifiers = Modifier.toString(fieldArr[0].getModifiers());
        // Получаем модификаторы поля в виде int-значения и декодируем их статическими
        // методами класса Modifier
        System.out.println(modifiers);

        Annotation[] annotations = SecretClass.class.getAnnotations();
        Arrays.stream(annotations).forEach(an -> System.out.println(an.toString()));



    }
}

@SuppressWarnings("unchecked")
class SecretClass {

    private final String secretString = "КОТ БАРСИК";
}
