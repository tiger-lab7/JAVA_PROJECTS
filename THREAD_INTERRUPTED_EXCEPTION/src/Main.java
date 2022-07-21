public class Main {
    public static void main(String[] args) throws InterruptedException {
        final ResourceClass resourceClass = new ResourceClass();

        Thread thread1 = new Thread(resourceClass::waiter);
        Thread thread2 = new Thread(resourceClass::waiter);

        thread1.start();
        Thread.sleep(3000);
        thread2.start();
        Thread.sleep(3000);
        thread2.interrupt();
    }
}

class ResourceClass {
    public synchronized void waiter() {
        System.out.println("Begin of method " + Thread.currentThread().getName());
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End of method " + Thread.currentThread().getName());
    }
}


