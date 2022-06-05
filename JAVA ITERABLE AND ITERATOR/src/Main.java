public class Main {

    public static void main(String[] args) {
        MyIterable<Integer> testIterable = new MyIterable<>(15);

        for(int i = 0; i < 10; i++) {
            testIterable.add(i * 2);
        }

        for(int val : testIterable) {
            System.out.println(val);
        }

        testIterable.forEach(System.out::println);

    }
}



