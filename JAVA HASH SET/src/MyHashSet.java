import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyHashSet {

    public MyHashSet(int capacity, float loadFactor) {

        List<ArrayList<Object>> hashTable = new ArrayList<ArrayList<Object>>(capacity);
    }


}

class Test{
    private int data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return data == test.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
