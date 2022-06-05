import java.util.Arrays;

public class Solution {
    private final StringBuilder output = new StringBuilder();

    public String convert(String s, int numRows) {

        String[][] result = new String[s.length()][numRows];
        output.ensureCapacity(s.length());

        int count = 0;
        int k = 0;

        Outer:
        while(count < s.length()) {
            for (int i = 0; i < numRows; i++) {
                result[k][i] = String.valueOf(s.charAt(count++));
                if (count == s.length()) break Outer;
            }
            for (int i = numRows - 2; i > 0; i--){
                result[++k][i] = String.valueOf(s.charAt(count++));
                if (count == s.length()) break Outer;
            }
            k++;
        }

        Arrays.stream(result)
                .forEach(arr -> System.out.println(Arrays.toString(arr) + "\n"));


        for (int n = 0; n < numRows; n++) {
            for (String[] stringRow : result) {
                if (stringRow[n] != null)
                    output.append(stringRow[n]);
            }
        }

        return output.toString();
    }
}
