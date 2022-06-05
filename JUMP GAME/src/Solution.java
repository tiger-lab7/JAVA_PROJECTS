import java.util.ArrayList;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Solution {
    private int[] nums;
    private int lastIndex;
    private int minPath;

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        this.nums = nums;
        lastIndex = nums.length - 1;
        minPath = Integer.MAX_VALUE;

        jumper(0, 0);
        return minPath;
    }

    // Recursive search for all possible combination of paths
    private void jumper(int startIndex, int jumpCount) {
        //if (nums[startIndex] == 0) return;

        jumpCount++;

        // This optimised the algorithm by canceling searches for a paths that longest then found earlier
        if (jumpCount > minPath) return;

        int jumpMaxIndex = startIndex + nums[startIndex];
        if (jumpMaxIndex >= lastIndex) {
            minPath = Math.min(minPath, jumpCount);
            return;
        }

        NavigableSet<Pairs<Integer>> perspectiveIndices = new TreeSet<>();
        for (int index = jumpMaxIndex; index > startIndex; index--){
            perspectiveIndices.add(new Pairs<Integer>(index, nums[index]));
        }

       // NavigableSet<Pairs<Integer>> perspectiveIndices1 = perspectiveIndices.descendingSet();
        //perspectiveIndices1.forEach(pair -> {System.out.println("index " + pair.index + "value" + pair.value);});

        for(Pairs<Integer> pair : perspectiveIndices) {

            jumper(pair.index, jumpCount);
        }

    }
}

class Pairs <T> implements Comparable<T> {
    public int index;
    public int value;

    public Pairs(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(T o) {
        Pairs obj = (Pairs) o;
        if(value < obj.value) return -1;
        if(value > obj.value) return 1;
        return 0;
    }
}
