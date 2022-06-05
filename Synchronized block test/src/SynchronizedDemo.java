import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedDemo implements Runnable {
    public static final int N = 1000;
    public static AtomicInteger count = new AtomicInteger(2);

    private final char threadChar;
    private final StringBuffer sb;

    public SynchronizedDemo(char threadChar, StringBuffer sb) {
        this.threadChar = threadChar;
        this.sb = sb;
    }
    public static void main(String[] args) throws InterruptedException {
        boolean failed;

        StringBuffer sb = new StringBuffer(4 * N);
        new Thread(new SynchronizedDemo('a', sb)).start();
        new Thread(new SynchronizedDemo('b', sb)).start();

        while(count.get() > 0) {
            Thread.sleep(1);
        }

        failed = sb.indexOf("aba") != -1 || sb.indexOf("bab") != -1;

        System.out.println(failed ? "failed " : "not failed");
    }


    @Override
    public void run() {
        for (int i = 0; i < N; i++) {
            // sb должен содержать пары aa и bb за счет синхронизации объекта StringBuffer
            synchronized (sb) {
                sb.append(threadChar);
                sleep();
                sb.append(threadChar); // снова добавляем то же символ потока после ожидания
            }                          // другой поток не имеет возможностти войти сюда
        }
        count.decrementAndGet();
    }

    private void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ignored) {
        }
    }
}
