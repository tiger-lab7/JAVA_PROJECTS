

public class RaceCondition {
    private volatile int x = 0;
    private boolean stop;

    Runnable incrementer = () -> { while(!stop) x++; };

    Runnable oddCheck = () -> {
        while(!stop) {
            if(x % 2 == 0) System.out.println(x);
        }
    };

    public void test() throws InterruptedException {

        new Thread(incrementer).start();
        new Thread(oddCheck).start();

        Thread.sleep(0,10);

        stop = true;
    }

}
