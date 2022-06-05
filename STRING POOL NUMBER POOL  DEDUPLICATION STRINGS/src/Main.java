public class Main {

    public static void main(String... args) {


        String str1 = "JAVA";
        String str2 = "JAVA";

        System.out.println(str1 == str2);

        String str3 = new String("JAVA");
        System.out.println(str2 == str3);

        str3 = str3.intern();
        System.out.println(str2 == str3);

        str2 = str1 + str2;
        String str4 = new String("JAVAJAVA");
        System.out.println(str2 == str4);

    }
}
