import java.util.Arrays;
import java.util.stream.IntStream;

public class Sort1 {
    private int[] array;

    public Sort1(int[] array) {
        this.array = array;
    }

    public static int[] mergeSort(int[] inputAr) {

        if (inputAr.length > 2) {
            int[] halfArray1 = Arrays.copyOfRange(inputAr, 0, inputAr.length / 2);
            int[] halfArray2 = Arrays.copyOfRange(inputAr, inputAr.length / 2, inputAr.length);
            mergeSort(halfArray1);
            mergeSort(halfArray2);

            int[] resultArray = Arrays.copyOf(halfArray1, halfArray1.length + halfArray2.length);
            System.arraycopy(halfArray2, 0, resultArray, halfArray1.length, halfArray2.length);

            //Arrays.sort(resultArray);
            int lastIndex = resultArray.length - 1;
            for (int i = 0; i < lastIndex; i++) {
                int minValue = resultArray[i];
                int minIndex = i;

                for (int j = i + 1; j < lastIndex + 1; j++) {
                    if (minValue > resultArray[j]) {
                        minValue = resultArray[j];
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    int temp = resultArray[i];
                    resultArray[i] = resultArray[minIndex];
                    resultArray[minIndex] = temp;
                }

            }

            return resultArray;
        }

        if (inputAr.length == 1) return inputAr;
        int temp;
        if (inputAr[0] > inputAr[1]) {
            temp = inputAr[0];
            inputAr[0] = inputAr[1];
            inputAr[1] = temp;
        }
        return inputAr;

    }

    public int[] sortByStream() {

        IntStream stream = Arrays.stream(array).sorted();

        array = stream.toArray();

        return array;
    }

    public int[] sortBubble() {
        int nextI, temp;
        boolean makeChange;

        do {
            makeChange = false;
            for (int i = 0; i < array.length - 1; i++) {
                nextI = i + 1;
                if (array[i] > array[nextI]) {
                    temp = array[i];
                    array[i] = array[nextI];
                    array[nextI] = temp;
                    makeChange = true;
                }
            }
        } while (makeChange);

        return array;
    }


}
