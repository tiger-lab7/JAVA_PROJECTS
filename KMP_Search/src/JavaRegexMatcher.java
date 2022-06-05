import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegexMatcher {

    public static void main(String[] args) {
        String subString = "кот";
        String sourceString = "Умнейший кот гадит очень немного";
        Pattern pattern = Pattern.compile(subString);
        Matcher matcher = pattern.matcher(sourceString);
        String result = "";
        if (matcher.find()) {
            result = String.format("%d %d", matcher.start(), matcher.end());
            //matcher.
        }
        System.out.println(result);
    }
}
