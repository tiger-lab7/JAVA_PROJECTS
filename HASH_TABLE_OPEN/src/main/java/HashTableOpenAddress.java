import java.util.Arrays;
import java.util.NoSuchElementException;

public class HashTableOpenAddress<K, V> {


    private final double LOAD_FACTOR_RATIO = 3;
    private final int INCREMENT_RATIO = 2;

    // Must be even!
    private final int SEARCH_STEP = 4;
    private int tableSize;
    private Object[] keysTable;
    private Object[] valuesTable;
    private int tableItems;

    HashTableOpenAddress() {
        this(16);
    }

    HashTableOpenAddress(int initialCapacity) {
        tableSize = Math.max(initialCapacity, 16);
        keysTable = new Object[tableSize];
        valuesTable = new Object[tableSize];
    }


    public void put(K key, V val) {
        // synchronized (this) {
        if (key == null) throw new IllegalArgumentException("Key is null");
        if (putToTable(keysTable, valuesTable, key, val)) tableItems++;
        if (tableItems * LOAD_FACTOR_RATIO >= tableSize) incrementTableSize();
        // }
    }

    // Puts key and value in the open-addressed hash table and returns true if the hash table
    // now consists a new item or returns false if the value by key in a hash table has been overwritten
    private boolean putToTable(Object[] keys, Object[] values, K key, V val) {
        int size = keys.length;
        int hash = key.hashCode();
        int index = Math.abs(hash % size);

        Object inTableKey = keys[index];
        // If such key not exists in keyTable, appending the key and the value to it's arrays
        if (inTableKey == null) {
            commit(keys, values, index, key, val);
            return true;
            // If such key exists and equals for the given,
            // simple reassign the value in values references array
        } else if (inTableKey.equals(key)) {
            values[index] = val;
            return false;
        }
        // If key supports hash2 method we will use it's result to calculate the search step,
        // else we will use default value of the search step.
        if (key instanceof Hash2Impl k) {
            int hash2 = k.hash2();
            int inc2 = Math.abs(hash2 % size);
            for (int index2 = index; index2 < size; index2 += inc2) {
                if (keys[index2] == null) {
                    commit(keys, values, index2, key, val);
                    return true;
                }
            }
            for (int index2 = 0; index2 < index; index2 += inc2) {
                if (keys[index2] == null) {
                    commit(keys, values, index2, key, val);
                    return true;
                }
            }
        } else {
            // Search an empty slot for key by linear probing
            for (int index2 = index + SEARCH_STEP; index2 < size; index2 += SEARCH_STEP) {
                if (keys[index2] == null) {
                    commit(keys, values, index2, key, val);
                    return true;
                }
            }
            // Search an empty slot for key from the begin of keyTable array
            for (int index2 = 0; index2 < index; index2 += SEARCH_STEP) {
                if (keys[index2] == null) {
                    commit(keys, values, index2, key, val);
                    return true;
                }
            }
        }
        return false;
    }


    private void commit(Object[] keys, Object[] values, int index, K key, V val) {
        keys[index] = key;
        values[index] = val;
    }


    // Creates a new oversize keyTable and a valuesTable
    // and puts to them all of the elements from a old arrays
    @SuppressWarnings("unchecked")
    private void incrementTableSize() {
        int newSize = tableSize * INCREMENT_RATIO;
        Object[] newKeysTable = new Object[newSize];
        Object[] newValuesTable = new Object[newSize];

        for (int i = 0; i < tableSize; i++) {
            if (keysTable[i] != null)
                putToTable(newKeysTable, newValuesTable, (K) keysTable[i], (V) valuesTable[i]);
        }
        keysTable = newKeysTable;
        valuesTable = newValuesTable;
        tableSize = newSize;
    }


    @SuppressWarnings("unchecked")
    public V get(K key) {
        // Primary fast search the key in the array keyTable by it's hash
        int hash = key.hashCode();
        int index = Math.abs(hash % tableSize);
        Object val;
        if (key.equals(keysTable[index])) {
            val = valuesTable[index];
            return (V) val;
        }
        // If key supports hash2 method we will use it's result to calculate the search step,
        // else we will use a default value of the search step.
        if (key instanceof Hash2Impl k) {
            int hash2 = k.hash2();
            int inc2 = Math.abs(hash2 % tableSize);
            for (int index2 = index; index2 < tableSize; index2 += inc2) {
                if (k.equals(keysTable[index])) {
                    val = valuesTable[index];
                    return (V) val;
                }
            }
            for (int index2 = 0; index2 < index; index2 += inc2) {
                if (k.equals(keysTable[index])) {
                    val = valuesTable[index];
                    return (V) val;
                }
            }
        } else {
            // Try to search the key righter in the array keyTable
            // with a linear probing
            for (int index2 = index + SEARCH_STEP; index2 < tableSize; index2 += SEARCH_STEP) {
                if (key.equals(keysTable[index2])) {
                    return (V) valuesTable[index2];
                }
            }
            // #3. Try to search the key from the begin of the array keyTable
            for (int index2 = 0; index2 < index; index2 += SEARCH_STEP) {
                if (key.equals(keysTable[index2])) {
                    return (V) valuesTable[index2];
                }
            }
        }
        // If all of the searches has been failed
        throw new NoSuchElementException("Key: " + key);
    }


    // Returns an Object array of all keys contained in the HashTable. Each key Object must
    // be casted to (K) type by user.
    public Object[] getKeysArray() {
        Object[] resultArray = new Object[tableSize];
        int resultArrayIter = 0;
        for (int i = 0; i < tableSize; i++) {
            if (keysTable[i] != null)
                resultArray[resultArrayIter++] = keysTable[i];
        }
        return Arrays.copyOf(resultArray, resultArrayIter);
    }

    // Returns an Object array of all values (included null values) contained in the HashTable with key.
    // Each value Object must be casted to (V) type by user.
    public Object[] getValuesArray() {
        Object[] resultArray = new Object[tableSize];
        int resultArrayIter = 0;
        for (int i = 0; i < tableSize; i++) {
            if (keysTable[i] != null)
                resultArray[resultArrayIter++] = valuesTable[i];
        }
        return Arrays.copyOf(resultArray, resultArrayIter);
    }

    @SuppressWarnings("unchecked")
    public Object[] getEntryArray() {
        // Inner class that implements HashTableOpenAddress.Entry interface
        class Entry implements HashTableOpenAddress.Entry<K, V> {
            private final K key;
            private final V val;

            protected Entry(K key, V val) {
                this.key = key;
                this.val = val;
            }

            @Override
            public K getKey() {
                return key;
            }

            @Override
            public V getValue() {
                return val;
            }
        }

        Object[] resultArray = new Object[tableSize];
        int resultArrayIter = 0;

        for (int i = 0; i < tableSize; i++) {
            if (keysTable[i] != null)
                resultArray[resultArrayIter++] = new Entry((K) keysTable[i], (V) valuesTable[i]);
        }
        return Arrays.copyOf(resultArray, resultArrayIter);
    }

    public int size() {
        return tableItems;
    }


    interface Entry<K, V> {
        K getKey();

        V getValue();
    }

}

