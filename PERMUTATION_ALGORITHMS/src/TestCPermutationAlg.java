import java.util.Arrays;

public class TestCPermutationAlg {

    public static void main(String[] args) {
        String[] myList =  {"b", "a", "r", "s", "i", "k"};


        CPermutationAlg<String> cPermutationAlg = new CPermutationAlg<>();
        int i = 1;
        for (var perm : cPermutationAlg.permutationList(Arrays.asList(myList))) {
            System.out.printf("%d %s \n", i++, perm);
        }
    }
}
