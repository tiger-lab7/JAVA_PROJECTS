public class Main {

    public static void main(String... args) {

        String string = "КОТ ВАСЯ!";
        System.out.println(string.getClass());

        if (string instanceof String str) {
            System.out.println(str + " " + str.getClass().getName());
        }
    }
}
