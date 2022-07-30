import java.lang.ref.WeakReference;

public class WeakReferenceExample {

    public static void main(String[] args) {
        WeakReference<TestClass> testClassWeakReference = new WeakReference<>(new TestClass());
        System.out.println("Before GC n = " + testClassWeakReference.get().n);

        System.gc();

        try {
            // testClass is destroyed and WeakReference not holding it
            System.out.println(testClassWeakReference.get().n);
        } catch (NullPointerException npe) {
            System.out.println("No object by reference!");
        }
    }
}
