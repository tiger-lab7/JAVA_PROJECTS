import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String... args) {
        Solution2 solution2 = new Solution2();
        double result = solution2.findMedianSortedArrays(new int[] {1,3}, new int[] {2,7});
        System.out.println(result);

    }

}

class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] intArray = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, intArray, 0, nums1.length);
        System.arraycopy(nums2, 0, intArray, nums1.length, nums2.length);

        //Arrays.stream(intArray).forEach(System.out::println);

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays
                .stream(intArray)
                .boxed()
                .collect(Collectors.toList()));

        int minMedian = 0;
        int maxMedian = 0;
        while(true) {
            minMedian = findMin(intArray);
            maxMedian = findMax(intArray);
            intArray[minMedian] =
        }



        return 0D;

    }
    private int findMax(int[] array) {
        int tmpInt = 0;
        int maxIndex = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > tmpInt) {tmpInt = array[i]; maxIndex = i;}
        }
        return maxIndex;
    }

    private int findMin(int[] array) {
        int tmpInt = array[0];
        int minIndex = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] < tmpInt) {tmpInt = array[i]; minIndex = i;}
        }
        return minIndex;
    }


}
