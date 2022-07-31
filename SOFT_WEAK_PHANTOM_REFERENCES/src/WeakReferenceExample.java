import java.lang.ref.WeakReference;

public class WeakReferenceExample {

    public static void main(String[] args) {
        WeakReference<TestClass> testClassWeakReference = new WeakReference<>(new TestClass());
        System.out.println("Before GC: " + testClassWeakReference.get());

        System.gc();

        // testClass is destroyed and WeakReference not holding it
        System.out.println("After GC: " + testClassWeakReference.get());

    }
}
