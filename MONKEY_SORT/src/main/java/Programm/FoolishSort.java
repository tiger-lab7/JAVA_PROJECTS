package Programm;

import static Util.Util.swap;

public class FoolishSort {

    public void sort(int[] A) {
        int i = 0;
        while (i < A.length - 1) {
            if (A[i] > A[i + 1]) {
                swap(A, i, i + 1);
                i = 0;
            }
            else i++;
        }
    }
}
