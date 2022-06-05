import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class WordParser {

    public static ArrayList<String> parseWords(@NotNull StringBuilder bigString) {
        ArrayList<String> wordArray = new ArrayList<>(Arrays.asList(bigString
                .toString()
                .split("\s"))
        );
        //  (ArrayList<String>) Arrays.stream(bigString.toString().split("\s")).collect(Collectors.toList());
    return wordArray;
    }
}
