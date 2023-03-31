import java.util.*;

public class SelectionSortIterators {
    static int arraySize = 1000;

    static void naiveSelectionSort(List<Integer> A) {
        for(int currentIndex = 0; currentIndex < A.size(); currentIndex++) {
            int minItemIndex = currentIndex;
            for (int i = currentIndex + 1; i < A.size(); i++) {
                if (A.get(minItemIndex) > A.get(i))
                    minItemIndex = i;
            }
            swap(A, minItemIndex, currentIndex);
        }
    }
    static void swap (List<Integer> A, int index1, int index2) {
        Integer tmp = A.get(index1);
        A.set(index1, A.get(index2));
        A.set(index2, tmp);
    }



    static void iteratorSelectionSort(List<Integer> integerList) {
        ListIterator<Integer> listIterator = integerList.listIterator();
        while (listIterator.hasNext()) {
            ListIterator<Integer> minimal = getMinIterator(integerList, integerList.listIterator(listIterator.nextIndex()));
            Integer current = listIterator.next();
            listIterator.set(minimal.next());
            minimal.set(current);
        }
    }
    static ListIterator<Integer> getMinIterator(List<Integer> list, ListIterator<Integer> iterator) {
        ListIterator<Integer> minPosition = list.listIterator(iterator.nextIndex());
        Integer min = iterator.next();
        while (iterator.hasNext()) {
            Integer current = iterator.next();
            if (current < min) {
                min = current;
                while (minPosition.nextIndex() < iterator.nextIndex() - 1) {
                    minPosition.next();
                }
            }
        }
        return minPosition;
    }


    static void fillListWithRandoms(List<Integer> integerList) {
        Random random = new Random();
        integerList.clear();
        for (int i = 0; i < arraySize; i++)
            integerList.add(random.nextInt(100));
    }

    static void measureTime(Runnable runnable) {
        long beginTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        System.out.println((endTime - beginTime) / 1000);
    }


    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>(arraySize);
        fillListWithRandoms(arrayList);
        LinkedList<Integer> linkedList = new LinkedList<>();
        fillListWithRandoms(linkedList);

        System.out.println("Naive Selection sort ArrayList: ");
        measureTime(() -> {
            naiveSelectionSort(arrayList);
        });
        System.out.println("Naive Selection sort LinkedList: ");
        measureTime(() -> {
            naiveSelectionSort(linkedList);
        });

        fillListWithRandoms(arrayList);
        fillListWithRandoms(linkedList);

        System.out.println("Iterator Selection sort ArrayList: ");
        measureTime(() -> {
            iteratorSelectionSort(arrayList);
        });
        System.out.println("Iterator Selection LinkedList: ");
        measureTime(() -> {
            iteratorSelectionSort(linkedList);
        });
    }
}
