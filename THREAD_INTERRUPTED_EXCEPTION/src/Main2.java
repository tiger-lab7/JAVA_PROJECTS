import java.util.concurrent.atomic.AtomicBoolean;

public class Main2 {
    public static AtomicBoolean atomicBoolean1 = new AtomicBoolean(true);
    public static AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> Class2.waiter(atomicBoolean1));
        Thread thread2 = new Thread(() -> Class2.waiter(atomicBoolean2));

        thread1.start();
        Thread.sleep(3000);
        thread2.start();
        Thread.sleep(3000);
        thread1.interrupt();
        thread2.interrupt();
        Thread.sleep(3000);

        atomicBoolean1.set(false);
        atomicBoolean2.set(false);
    }
}

class Class2 {
    public static synchronized void waiter(AtomicBoolean atomicBoolean) {
        System.out.println("Begin of method " + Thread.currentThread().getName());
        while (atomicBoolean.get()) {
        }
        System.out.println("End of method " + Thread.currentThread().getName());
    }
}