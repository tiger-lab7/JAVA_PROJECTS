import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExample {

    public static void main(String[] args) {
        ReferenceQueue<TestClass> referenceQueue = new ReferenceQueue<>();

        PhantomReference<TestClass> testClassPhantomReference =
                new PhantomReference<>(new TestClass(), referenceQueue);

        testClassPhantomReference.enqueue();

        try {
            // testClass
            System.out.println(testClassPhantomReference.get().n);
        } catch (NullPointerException npe) {
            System.out.println("No object by reference!");
        }

        System.out.println(referenceQueue.poll().get());
    }
}