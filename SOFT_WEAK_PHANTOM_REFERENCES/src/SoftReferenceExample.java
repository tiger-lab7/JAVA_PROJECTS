import java.lang.ref.SoftReference;

public class SoftReferenceExample {


    public static void main(String[] args) {
        SoftReference<TestClass> testClassSoftReference = new SoftReference<>(new TestClass());

        System.gc();

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
        long heapMaxSize = Runtime.getRuntime().maxMemory();
        System.out.println(heapMaxSize);
        int[] array = new int[(int)(heapMaxSize / 4.02)];
    }
}
