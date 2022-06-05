import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Stream;

public class ForkJoinPoolTest {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool(2); // Указать число потоков, чтобы избежать полной загрузки

        Task task = new Task(BigInteger.valueOf(512L));

        // Основной метод - без использования прямого вызова ForkJoinPool
        //task.fork();
        //System.out.println(task.join());

        System.out.println(forkJoinPool.invoke(task));
    }
}

class Task extends RecursiveTask<BigInteger> {
    private BigInteger n;

    public Task(BigInteger n) {
        this.n = n;
    }

    @Override
    protected BigInteger compute() {
        if(n.intValue() == 2) return BigInteger.ONE;

        Task task1 = new Task(n.divide(BigInteger.valueOf(2L)));
        Task task2 = new Task(n.divide(BigInteger.valueOf(2L)));
        task1.fork();
        task2.fork();
        BigInteger result1 = task1.join();
        BigInteger result2 = task2.join();
        return result1.add(result2);
    }
}
