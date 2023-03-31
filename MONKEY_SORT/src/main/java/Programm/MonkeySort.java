package Programm;

import static Util.Util.swap;

import java.util.Random;


public class MonkeySort {
    private Random random = new Random();
    private int[] A;

    public void sort(int[] A) {
        this.A = A;
        while (isNotOrdered())
            shuffleAll();
    }

    private void shuffleOne() {
        int randomInt = random.nextInt(A.length);
        int tmp = A[0];
        A[0] = A[randomInt];
        A[randomInt] = tmp;
    }

    private void shuffleAll() {
        for (int i = 0; i < A.length; i++) {
            int randomInt = random.nextInt(A.length);
            swap(A, i, randomInt);
        }
    }


    private boolean isNotOrdered() {
        for (int i = 0; i < A.length - 1; i++)
            if (A[i] > A[i + 1])
                return true;
        return false;
    }
}