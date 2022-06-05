public class Main {

    public static void main(String[] args) {

        IterableLinkedList<Double> doubleIterableLinkedList = new IterableLinkedList<>();
        for(int i = 0; i < 100; i++) {
            doubleIterableLinkedList.add((double) i);
        }

        // Перебор методом forEach, принимающим лямбду Consumer
        doubleIterableLinkedList.forEach(System.out::println);

        // Перебор циклом for-each
        for(double val : doubleIterableLinkedList) {
            System.out.println(val);
        }


    }
}
