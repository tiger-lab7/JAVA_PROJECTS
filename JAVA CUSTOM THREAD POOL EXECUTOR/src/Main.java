import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(Integer.MAX_VALUE,
                        Integer.MAX_VALUE,
                        10L,
                        TimeUnit.MILLISECONDS,
                        blockingQueue);
        for (int i = 0; i < 10; i++)
            threadPoolExecutor.execute(() -> {
                System.out.println("Hello " + Thread.currentThread().getName() + "!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        threadPoolExecutor.shutdown();
    }
}
