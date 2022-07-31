import java.util.WeakHashMap;

public class WeakHashMapExample {

    public static void main(String[] args) throws InterruptedException {

        WeakHashMap<TestClass, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(new TestClass(), "Object1");
        System.gc();
        Thread.sleep(1000);

        weakHashMap.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
    }
}
