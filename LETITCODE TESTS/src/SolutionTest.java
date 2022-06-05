import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @Test
    public void firstTest() {

        Solution solution = new Solution();
        double result = solution.findMedianSortedArrays(new int[] {0,0}, new int[] {0,0});
        Assert.assertEquals(result, 0D, 0);
    }

}