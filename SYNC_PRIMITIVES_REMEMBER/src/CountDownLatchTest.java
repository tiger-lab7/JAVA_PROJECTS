import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(5);

        Runnable basicTask = () -> {
            System.out.println("Basic task started!");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Basic thread finished!");
        };

        Random random = new Random();
        Runnable actionTask = () -> {
            System.out.printf("Thread %s started!\n", Thread.currentThread().getName());
            try {
                Thread.sleep(random.nextInt(1000, 5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Thread %s finished!\n", Thread.currentThread().getName());

            countDownLatch.countDown();
        };

        new Thread(basicTask).start();

        for(int i = 0; i < 5; i++) {
            new Thread(actionTask).start();
        }

    }
}