public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.reverse(-123));
    }
}

class Solution {
    public int reverse(int x) {
        char[] result = Integer.toString(x).toCharArray();
        int s = 0;
        if (result[0] == '-') s = 1;
        for (; s < result.length; s++){
            char tmp = result[s];
            result[s] = result[result.length - s - 1];
            result[result.length - s - 1] = tmp;
        }
        long re = Long.parseLong(new String(result));
        if (re > Integer.MAX_VALUE || re < Integer.MIN_VALUE) return 0;
        return (int)re;

    }
}
