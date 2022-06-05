import java.math.BigInteger;

public class FibbonachiTimeTrial {
    private static final int TESTS = 100;
    private static final int N = 20000;


    static BigInteger fibbonDP(final int n) {
        BigInteger[] dpArray = new BigInteger[n];
        dpArray[1] = new BigInteger("1");
        dpArray[2] = new BigInteger("2");

        for (int i = 3; i < n; ++i) {
            dpArray[i] = BigInteger.ZERO
                    .add(dpArray[i - 1])
                    .add(dpArray[i - 2]);
        }
        return dpArray[n - 1];
    }

    public static void main(String[] args) throws InterruptedException {

        BigInteger result = null;

        // Warm up...
        for (int i = 0; i < TESTS; ++i) {
            result = fibbonDP(N);
        }

        // Cool down...
        Thread.sleep(500);

        // Testing!
        long begin = System.nanoTime();
        for (int i = 0; i < TESTS; ++i) {
            result = fibbonDP(N);
        }
        long end = System.nanoTime();
        System.out.println("Result: " + result.toString()
                + " Time: " + (end - begin)/1000 + " ms");
    }
}
