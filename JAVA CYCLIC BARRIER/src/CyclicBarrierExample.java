import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierExample {

    public static void main(String... args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger( 0);

        // Action that will fire when the barrier will broken
        Runnable brokenAction = () -> {
            System.out.println(" WARNING! BARRIER IS BROKEN! ");
            count.incrementAndGet();
        };

        // Creating the CyclicBarrier object
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, brokenAction);

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("TASK in  " + threadName + " started!");
            for(int i = 0; i < 3; i++) {
                try {
                    int delay = (int) (Math.random() * 1000) * 3; // Random time of sleep for each thread (0 - 3 sec)
                    Thread.sleep(delay);
                    cyclicBarrier.await(); // Stops and synchronize all threads here
                    System.out.println("Iteration " + i + " finished! " + threadName);
                } catch (InterruptedException | BrokenBarrierException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("TASK in  " + threadName + " finished!");
        };

        // Starting 10 new Threads with Runnable task in each, synchronized by the CyclicBarrier
        for(int i = 0; i < 10; i++) {
            new Thread(task).start();
        }

        // Waiting in the Main thread
        do {
            Thread.sleep(600);
            System.out.println("Waiting: " + cyclicBarrier.getNumberWaiting());
        } while (count.get() != 3); // Correct condition
    }
}


