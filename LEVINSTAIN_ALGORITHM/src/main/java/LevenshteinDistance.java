import java.util.Arrays;

public class LevenshteinDistance {


    public static int levenshteinDistanceCount(String wordA, String wordB) {

        int sizeA = wordA.length() + 1;
        int sizeB = wordB.length() + 1;
        int[][] DP = new int[sizeA][sizeB];
        for(int i = 0; i < sizeA; i++) DP[i][0] = i;
        for(int j = 0; j < sizeB; j++) DP[0][j] = j;
        printDP("Исходная таблица DP. Крайние случаи.", DP); // Source table DP. Extreme cases

        for(int i = 1; i < sizeA; i++) {
            for(int j = 1; j < sizeB; j++) {
                if(wordA.charAt(i - 1) == wordB.charAt(j - 1)) {
                    DP[i][j] = DP[i - 1][j - 1];
                }
                else {
                    DP[i][j] = 1 + findMin(DP[i][j - 1], DP[i - 1][j], DP[i - 1][j - 1]);
                }

            }
        }
        printDP("Результат заполнения таблицы DP", DP); // Result of filling the DP table
        return DP[sizeA - 1][sizeB - 1];
    }

    private static int findMin(int... x) {
        return Arrays.stream(x).min().orElseGet(() -> 0);
    }

    private static void printDP(String message, int[][] DP) {
        System.out.println(message);
        Arrays.stream(DP)
                .forEach(B -> {
                            Arrays.stream(B)
                                    .forEach(x -> System.out.print(x + " "));
                    System.out.println("");
                        }
                );
    }
}
