import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsIterative {

    public static <T> List<List<T>> permutations(List<T> inputList){

        List<List<T>> permutationsList = new ArrayList<>();

        if(inputList.isEmpty()){
            return permutationsList;
        }

        // We add the first element
        permutationsList.add(new ArrayList<>(Collections.singletonList(inputList.get(0))));

        // Then, for all elements e in inputList (except the first)
        for (int i = 1, len = inputList.size(); i < len; i++) {
            T e = inputList.get(i);

            // We take and remove each list l from 'permutationsList'
            for (int j = permutationsList.size() - 1; j >= 0; j--) {
                List<T> l = permutationsList.remove(j);

                // And adds a copy of l, with e inserted at index k for each position k in l
                for (int k = l.size(); k >= 0; k--) {
                    ArrayList<T> ts2 = new ArrayList<>(l);
                    ts2.add(k, e);
                    permutationsList.add(ts2);
                }
            }
        }
        return permutationsList;
    }
}
