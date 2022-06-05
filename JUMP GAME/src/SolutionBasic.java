public class SolutionBasic {

        private int[] nums;
        private int lastIndex;
        private int minPath = Integer.MAX_VALUE;

        public int jump(int[] nums) {
            if (nums.length == 1) return 0;
            this.nums = nums;
            lastIndex = nums.length - 1;

            jumper(0, 0);
            return minPath;
        }

        // Recursive search for all possible combination of paths
        private void jumper(int startIndex, int jumpCount) {
            if (nums[startIndex] == 0) return;

            jumpCount++;
            // This optimised search by cancel searching for paths longest that found earlier
            if (jumpCount > minPath) return;

            int jumpMaxIndex = startIndex + nums[startIndex];
            if (jumpMaxIndex >= lastIndex) {
                minPath = Math.min(minPath, jumpCount);
                return;
            }

            for (int i = jumpMaxIndex; i > startIndex; i--) {
                jumper(i, jumpCount);
            }
        }
    }


