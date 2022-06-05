public class RaceConditionSolve {
    private int x = 0;
    private boolean stop;

    Runnable incrementer = () -> {
        synchronized (this) {
            while (!stop) {
                x++;
                try {
                    if (x % 10 == 0) wait();
                } catch (InterruptedException ignored) {}
            }
        }
    };

    Runnable oddCheck = () -> {

        while(!stop) {
            synchronized (this) {
                if (x % 2 == 0) System.out.println("Solved: " + x);
                notifyAll();
            }
        }
    };

    public void test() throws InterruptedException {

        new Thread(incrementer).start();
        new Thread(oddCheck).start();

        Thread.sleep(100);

        stop = true;
    }
}
