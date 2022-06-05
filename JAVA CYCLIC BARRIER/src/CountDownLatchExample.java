import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String... args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for(int i = 0; i < 10; ++i) {
            new TestThread(countDownLatch);
            System.out.println(countDownLatch.getCount() + " left!");
        }

        countDownLatch.await(); // Здесь блокируется

        System.out.println("Count down finished!");
    }
}

class TestThread implements Runnable {
    private final CountDownLatch countDownLatch;

    TestThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Count down -1!");
        countDownLatch.countDown(); // Здесь не происходит блокировка, потоки выполняются дальше
        System.out.println("Thread " + Thread.currentThread().getId() + " finished");
    }
}