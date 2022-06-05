import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class HashTableOpenAddressTest {
    private Map<TestObject, String> referenceMap;
    private int TEST_LIST_SIZE = 10000;

    @Test
    void testRandom() {
        HashTableOpenAddress<TestObject, String> hashTable = new HashTableOpenAddress<>(TEST_LIST_SIZE);
        referenceMap = new HashMap<>(TEST_LIST_SIZE);
        //List<TestObject> testObjectList = generateRandomKeys();
        List<TestObject> testObjectList = generateRandomKeysHash2();

        Object[] result1, result2;
        long begin = System.nanoTime();
        for (var key : testObjectList) {
            referenceMap.put(key, "Cat Oliver");
        }
        result1 = referenceMap.keySet().toArray();
        long end = System.nanoTime();
        System.out.printf("Java Collections HashMap: %d ms \n", (end - begin) / 1000);

        begin = System.nanoTime();
        for (var key : testObjectList) {
            hashTable.put(key, "Cat Oliver");
        }
        result2 = hashTable.getKeysArray();
        end = System.nanoTime();
        System.out.printf("HashTableOpenAddress: %d ms \n", (end - begin) / 1000);

        Assertions.assertEquals(CollectionUtils.toSet(result1), CollectionUtils.toSet(result2));
    }

    @Test
    @SuppressWarnings("unchecked")
    void trivialTest() {
        // Try to create a zero-capacity hash table
        HashTableOpenAddress<String, String> hashTable = new HashTableOpenAddress<>(0);

        // Put 2 items and checks has table size
        hashTable.put("TestKey1", "TestValue1");
        Assertions.assertEquals(hashTable.size(), 1);
        hashTable.put("TestKey2", "TestValue2");
        Assertions.assertEquals(hashTable.size(), 2);

        // Try to get the items
        Assertions.assertEquals(hashTable.get("TestKey1"), "TestValue1");
        Assertions.assertEquals(hashTable.get("TestKey2"), "TestValue2");

        // Try to get non-existent item and checks the threw exception
        Assertions.assertThrows(java.util.NoSuchElementException.class,
                () -> hashTable.get("TestKey3"), "Key: TestKey3");

        // Add another item and checks getEntryArray method
        hashTable.put("TestKey4", "TestValue4");

        Object[] entryArray = hashTable.getEntryArray();
        Assertions.assertEquals(entryArray.length, 3);
        ArrayList<String> values = (ArrayList<String>) Arrays.stream(entryArray)
                .flatMap(obj -> Stream.of((String) ((HashTableOpenAddress.Entry<String, String>) obj).getValue()))
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        Assertions.assertLinesMatch(values, List.of("TestValue1", "TestValue2", "TestValue4"));
    }


    private List<TestObject> generateRandomKeys() {
        List<TestObject> testObjectList = new ArrayList<>(TEST_LIST_SIZE);
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            testObjectList.add(i, new TestObject(random.nextInt(1000)));
        }
        return testObjectList;
    }

    private List<TestObject> generateRandomKeysHash2() {
        List<TestObject> testObjectList = new ArrayList<>(TEST_LIST_SIZE);
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            testObjectList.add(i,
                    new TestObjectHash2(random.nextInt(1000), random.nextInt(1000)));
        }
        return testObjectList;
    }
}