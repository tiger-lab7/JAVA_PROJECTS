import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) {

        // COLLECTIONS:

        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,10,10));

        List<Integer> linkedList = new LinkedList<>(arrayList);

        Set<Integer> hashSet = new HashSet<>(linkedList);

        Set<Integer> treeSet = new TreeSet<>(hashSet);

        Queue<Integer> linkedList1 = new LinkedList<>(treeSet);

        Deque<Integer> linkedList2 =new ArrayDeque<>(linkedList1);

        // MAPS:

        Map<Integer,Integer> hashMap = new HashMap<>(Map.of(1,1,2,2,3,3,4,4));// Так можно до 10 пар

        Map<Integer, Integer> treeMap = new TreeMap<>() {
            {
                put(23,23);
                put(45,45);
                put(96,96);
            }
        };

        NavigableMap<Integer,Integer> navigableMap = (NavigableMap<Integer, Integer>) treeMap;
        System.out.println(navigableMap.ceilingKey(10));

        Map<Integer, Integer> map = Stream.of(new Integer[][] {
                {1,111},
                {2,222},
                {3,333}
        }).collect(Collectors.toMap(k -> k[0], v -> v[1]));

        Comparator<Integer> comparator = (a,b) -> a - b;
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);
        mapPrinter(sortedMap);

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>(map);

        Set set = linkedHashMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry item = (Map.Entry) iterator.next();
            System.out.println("Ключ: " + item.getKey() + " значение: " + item.getValue());
        }

        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()) {
            Map.Entry item = (Map.Entry) iterator1.next();
            System.out.println("Ключ: " + item.getKey() + " значение: " + item.getValue());
        }



        //printer(linkedList2);
        //genericPrinter(linkedList2);
        //mapPrinter(hashMap);
        //mapPrinter(treeMap);


        arrayList.set(1, 101); // set устанавливает значение для указанной 1- м параметром позицию
        arrayList.add(122); // add дополняет коллекцию новым элементов в конце
        arrayList.remove((Integer) 10); // remove умеет удалять элемент по значению, находит первый
        //genericPrinter(arrayList);

    }

    static void printer (Collection<?> inputCollection){
        for(Object object : inputCollection) {
            System.out.println(object);
        }
    }

    static <E> void genericPrinter(Collection<E> inputCollection){ // <E> пишется перед возвращаемым типом в методе!
        for(E element : inputCollection) {
            System.out.println(element);
        }
    }

    static void mapPrinter(Map<?,?> inputMap) {
        inputMap.forEach((k, v) -> System.out.println(k.toString() + " " + v.toString()));//Идет захват(capture) wildcard`ов
    }
}
