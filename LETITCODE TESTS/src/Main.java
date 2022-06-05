import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String... args) {
        Solution solution = new Solution();
        double result = solution.findMedianSortedArrays(new int[] {1,3}, new int[] {2,7});
        System.out.println(result);

    }

}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.stream(nums1).boxed().collect(Collectors.toSet()));
        treeSet.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toSet()));

        double middleValue = (double)(treeSet.stream().reduce((acc, x) -> acc += x).get()) / treeSet.size();

        Integer lowerElem = treeSet.lower((int)Math.ceil(middleValue));
        Integer upperElem = treeSet.higher((int)Math.floor(middleValue));
        lowerElem = (lowerElem == null)? treeSet.first() : lowerElem;
        upperElem = (upperElem == null)? treeSet.last() : upperElem;

        System.out.println(middleValue + " " + lowerElem + "  " + upperElem);
        return (double) (upperElem + lowerElem) / 2;

    }
}
