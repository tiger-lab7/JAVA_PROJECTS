import java.util.Arrays;

public class Solution1 {
    private final StringBuilder output = new StringBuilder();

    public String convert(String s, int numRows) {

        char[][] result = new char[s.length()][numRows];

        int count = 0;
        int k = 0;

        Outer:
        while(count < s.length()) {
            for (int i = 0; i < numRows; i++) {
                result[k][i] = s.charAt(count++);
                if (count == s.length()) break Outer;
            }
            for (int i = numRows - 2; i > 0; i--){
                result[++k][i] = s.charAt(count++);
                if (count == s.length()) break Outer;
            }
            k++;
        }

        Arrays.stream(result)
                .forEach(arr -> System.out.println(Arrays.toString(arr) + "\n"));


        for (int n = 0; n < numRows; n++) {
            for (char[] charRow : result) {
                if (charRow[n] != Character.MIN_VALUE)
                    output.append(charRow[n]);
            }
        }

        return output.toString();
    }
}
