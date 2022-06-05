import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        int n = 100;
        Callable<Integer> callableLambda = () -> {return n * n;};

        Future<Integer> integerFuture = executorService.submit(callableLambda);

        Thread.sleep(100);

        int result = 0;
        if(integerFuture.isDone()) result = integerFuture.get();

        System.out.println(result);
    }
}
