public class JavaLambdas1 {

    public static void main(String... args) {
        String x = "ПРИВЕТ, Я КОТ!";
        String y = "HELLO, I AM CAT!";

        LambdaInterface lambda1 = (String input) -> {

            char[] charString = input.toCharArray();
            int lenArray = charString.length;
            char[] charStringOut = new char[lenArray];
            for (int i = 0; i < lenArray; i++) {
                charStringOut[i] = charString[lenArray - 1 - i];
            }
            return new String(charStringOut);
        };

        System.out.println(lambda1.invertString(x));
        System.out.println(lambda1.invertString(y));

    }
}

interface LambdaInterface{
    String invertString(String input);
}
//Это единственный метод, который мы реализуем в анонимной лямбде, но имя которого
// используем при вызове лямбды


