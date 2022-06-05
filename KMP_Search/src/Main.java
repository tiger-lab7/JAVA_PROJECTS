import java.util.Arrays;

class KMPSearch {

    int[] prefixFunc(String s) {
        int len = s.length();
        int[] pf = new int[len];

        for (int i = 1; i < len; ++i) {
            int j = pf[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = pf[j - 1];
            if (s.charAt(i) == s.charAt(j)) j++;
            pf[i] = j;
        }
        return pf;
    }
    int[] findSubstring(String sub, String s) {
        s = sub + "#" + s;

        int[] pf = prefixFunc(s);

        int resultBegin = -1;
        int resultEnd = -1;
        int subLength = sub.length();
        for (int i = 0; i < pf.length; ++i) {
            if (pf[i] == subLength) {
                resultEnd = i - subLength;
                resultBegin = resultEnd - subLength;
            }
        }
        return new int[] {resultBegin, resultEnd};
    }

    class MatchIterator {

    }
}

public class Main {
    public static void main(String[] args) {
        KMPSearch kmpSearch = new KMPSearch();
        //int[] result = kmpSearch.prefixFunc("qweeeeeeeqw");
        //System.out.println(Arrays.toString(result));
        String subString = "кот";
        String sourceString = "Умнейший кот гадит очень немного";
        int[] result = kmpSearch.findSubstring(subString, sourceString);
        System.out.printf("%d %d",result[0], result[1]);
    }
}
