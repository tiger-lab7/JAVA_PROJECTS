import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Predicator {

    public static void main(String... args) {
        Predicate<Integer> predicate1 = a -> a > 10;

        String inpustString = "FIFA does never regret this!";
        Pattern pattern = Pattern.compile("//s");
        Matcher matcher = pattern.matcher(inpustString);
        if (matcher.find()) System.out.println("found");

        Predicate<String> predicate2 = a -> a.matches("//s");
    }
}
