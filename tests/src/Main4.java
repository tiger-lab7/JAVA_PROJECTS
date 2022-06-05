import java.util.Scanner;

public class Main4 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        // Перевести инт-число в бинарное представление в строке методом Integer.toBinaryString
        System.out.println(Integer.toBinaryString(N));

        // Или циклом
        String s = "";
        for (int n = N; n > 0; n /= 2) s = (n % 2) + s;
        System.out.println(s);

    }
}
