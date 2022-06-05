import java.util.Arrays;

public class TestPermutationIterative {

    public static void main(String[] args) {
        String[] myList =  {"b", "a", "r", "s", "i", "k"};

        int i = 1;
        for (var perm : PermutationsIterative.permutations(Arrays.asList(myList))) {
            System.out.printf("%d %s \n", i++, perm);
        }
    }
}
