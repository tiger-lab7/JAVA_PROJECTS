import java.util.Scanner;

public class Main2 {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        double x = Double.parseDouble(input1);

        String input2 = scanner.nextLine();
        double y = Double.parseDouble(input2);

        System.out.println(x > 0.0 && x < 1.0 && y > 0.0 && y < 1.0);

    }
}
