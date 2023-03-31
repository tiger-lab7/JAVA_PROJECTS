package src;

import java.util.Arrays;
import java.util.Scanner;

public class Eratosthenes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите максимальное число для поиска простых чисел включительно");
        int N = sc.nextInt();
        eratosthenesCount(N);
    }

    private static void eratosthenesCount(int N) {
        boolean[] A = new boolean[N + 1];
        Arrays.fill(A, true);

        int x = 2;
        while (x * x <= N) {
            if (A[x]) {
                for (int i = x * x; i <= N; i += x)
                    A[i] = false;
            }
            x++;
        }

        for (x = 2; x <= N; x++)
            if (A[x]) System.out.print(x + "\t");
    }
}