import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Input the first word");
            String stringA = scanner.nextLine();
            System.out.println("Input the second word");
            String stringB = scanner.nextLine();
            if(stringA.equals("") || stringB.equals("")) break;
            System.out.println("Результат: " +
                LevenshteinDistance.levenshteinDistanceCount(stringA, stringB));
        }
    }
}
