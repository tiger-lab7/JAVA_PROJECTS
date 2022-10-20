import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> myHashMap = new HashMap<>();
        myHashMap.put(null, "Null value in HashMap");
        myHashMap.put(1, "One value in HashMap");
        for(Map.Entry<Integer, String> entry : myHashMap.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());


        Map<Integer, String> myHashTable = new Hashtable<>();
        try {
            myHashTable.put(null, "Null value in HashTable");
        } catch (NullPointerException ex) {ex.printStackTrace();}

        myHashTable.put(1, "One value in HashTable");

        Iterator<Integer> integerIterator = myHashTable.keySet().iterator();
        while (integerIterator.hasNext()) {
            Integer key = integerIterator.next();
            System.out.println(key + ": " + myHashTable.get(key));
        }
    }
}
