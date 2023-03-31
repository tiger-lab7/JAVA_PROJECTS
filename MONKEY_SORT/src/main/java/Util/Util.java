package Util;

public class Util {
    public static void swap(int[] A, int index1, int index2) {
        int tmp = A[index1];
        A[index1] = A[index2];
        A[index2] = tmp;
    }
}
