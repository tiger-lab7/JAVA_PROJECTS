import java.util.NavigableSet;
import java.util.TreeSet;

public class SolutionWithSet {
    private int[] nums;
    private int lastIndex;
    private NavigableSet<Integer> resultSet = new TreeSet();
    private long calls = 0;

    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        this.nums = nums;
        lastIndex = nums.length - 1;
        jumper(0, 0);

        resultSet.forEach(System.out::println);
        return resultSet.pollFirst();
    }

    private void jumper(int startIndex, int jumpCount) {
        if(nums[startIndex] == 0) return;
        //System.out.println(calls);
        jumpCount++;
        int jumpMaxIndex = startIndex + nums[startIndex];

        if(jumpMaxIndex >= lastIndex) {
            resultSet.add(jumpCount);
            return;
        }

        for(int i = jumpMaxIndex; i > startIndex; i--) {
            jumper(i, jumpCount); calls++;
        }
    }
}
