import java.util.Arrays;

public class JavaLambdas2 {

    public static void main(String... args) {
        String x = "ПРИВЕТ, Я КОТ!";
        String y = "HELLO, I AM CAT!";

        LambdaInterface2 lambda2 = (String input) -> {

            char[] charString = new char[input.length()];
            input.getChars(0, input.length(), charString,0);
            System.out.println(charString.length);
            return new String(charString);
        };

        System.out.println(lambda2.invertString(x));
        System.out.println(lambda2.invertString(y));

    }
}

interface LambdaInterface2{
    String invertString(String input);
}
//Это единственный метод, который мы реализуем в анонимной лямбде, но имя которого
// используем при вызове лямбды


