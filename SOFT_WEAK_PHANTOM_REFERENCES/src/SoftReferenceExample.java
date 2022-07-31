import java.lang.ref.SoftReference;

public class SoftReferenceExample {


    public static void main(String[] args) throws InterruptedException {
        SoftReference<TestClass> testClassSoftReference = new SoftReference<>(new TestClass());

        System.gc();
        Thread.sleep(1000);
        // testClass object still alive because the memory has not been full yet
        System.out.println("Before memory overflow: " + testClassSoftReference.get());

        memoryFiller();

        try {
            // testClass object was destroyed by memory overflow
            System.out.println(testClassSoftReference.get().n);
        } catch (NullPointerException npe) {
            System.out.println("No object by reference!");
        }
    }

    public static void memoryFiller() {
        int[] array = new int[246_000_000]; // Empiric value for overflow the heap memory
    }
}
