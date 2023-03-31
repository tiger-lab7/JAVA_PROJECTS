import java.util.Random;
import java.util.concurrent.Phaser;

public class PhaserTest {

    public static void main(String[] args) {
        Random random = new Random();

        Phaser phaser = new Phaser();
        Runnable task = () -> {
            phaser.register();
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " started!");

            while (phaser.getPhase() < 3) {
                try {
                    Thread.sleep(random.nextInt(1000, 5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(threadName + " has completed phase " + phaser.getPhase());
                System.out.println("Wait for "
                        + (phaser.getRegisteredParties() -  phaser.getArrivedParties() - 1));
                phaser.arriveAndAwaitAdvance();

                /*if (phaser.getArrivedParties() == phaser.getRegisteredParties())
                    System.out.println("All threads has been completed the phase!");*/
            }
        };

        for (int i = 0 ; i < 5; i++)
            new Thread(task).start();
    }
}
