import java.lang.reflect.Field;

public class StringDeduplication {

    public static void main(String... args) throws NoSuchFieldException,
            IllegalAccessException, InterruptedException {

        char[] chars = {'J','A','V','A'};
        String[] strings = {new String(chars), new String(chars)};

        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);

        System.out.println("Хэш объекта строки 1 " + field.get(strings[0]));
        System.out.println("Хэш объекта строки 2 " + field.get(strings[1]));

        System.gc();
        System.out.println("Запустили сборщик мусора");

        Thread.sleep(1000);
        System.out.println("Ждём 1 с");

        System.out.println("Хэш объекта строки 1 " + field.get(strings[0]));
        System.out.println("Хэш объекта строки 2 " + field.get(strings[1]));

       /* String str1 = new String("JAVA");
        String str2 = new String("JAVA");
        System.out.println(str1 == str2);*/


    }
}
