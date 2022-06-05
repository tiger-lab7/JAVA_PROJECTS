import java.util.Random;

public class Main {

    public static void main(String[] args) {
        HashTableOpenAddress<TestObject, String> hashTable = new HashTableOpenAddress<>(5);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            //int randomKey = random.nextInt(50);
            hashTable.put(new TestObject(i), "Cat Barsik");
            //hashTable.put(i + 1, "Cat Oliver");
        }

        for (Object key : hashTable.getKeysArray()) {
            System.out.printf("%s %s\n", key, hashTable.get((TestObject) key));
        }
        for (Object val : hashTable.getValuesArray()) {
            System.out.println(val);
        }
    }
}
