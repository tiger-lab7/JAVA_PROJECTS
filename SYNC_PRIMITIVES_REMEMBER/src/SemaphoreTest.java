import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);

        Random random = new Random();
        Runnable actionTask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.printf("Thread %s started!\n", threadName);
            try {
                semaphore.acquire();
                System.out.printf("Thread %s working...\n", threadName);
                Thread.sleep(random.nextInt(1000, 5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Thread %s finished!\n", threadName);

            semaphore.release();

        };

        for(int i = 0; i < 10; i++) {
            new Thread(actionTask).start();
        }

    }
}
