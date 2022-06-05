import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CPermutationAlg<T extends Comparable<T>> {
    private List<T> inputList;

    public List<List<T>> permutationList(List<T> inp) {
        inputList = inp;
        List<List<T>> result = new ArrayList<>();
        while(next_permutation(0, inputList.size() - 1)) {
            result.add(new ArrayList<>(inputList));
        }
        return result;
    }

    private boolean next_permutation(int first, int last) {
        if (first == last)
            return false;
        int i = first;
        ++i;
        if (i == last)
            return false;
        i = last;
        --i;

        while(true) {
            int ii = i;
            --i;
            if (inputList.get(i).compareTo(inputList.get(ii)) < 0) {
                int j = last;
                while (inputList.get(i).compareTo(inputList.get(--j)) >= 0) {}
                Collections.swap(inputList, i, j);
                reverse(ii, last);
                return true;
            }
            if (i == first) {
                reverse(first, last);
                return false;
            }
        }
    }

    private void reverse(int i, int j) {
        for(int k = 0; k < (j - i) / 2 ; k++) {
            Collections.swap(inputList, i + k, j - k);
        }
    }
}
