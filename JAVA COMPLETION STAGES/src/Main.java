import java.math.BigInteger;
import java.util.concurrent.*;
import java.util.function.Function;

public class Main {

    public static void main(String... args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Function<Long, BigInteger> task = (Long number) -> {
            BigInteger factorial = BigInteger.ONE;
            for(long i = 1; i < number + 1; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            return factorial;
        };

        long number1 = 500L, number2 = 1500L;

        // Non-blocking launch and output of results of two tasks using CompletableFuture<Void> class.
        CompletableFuture
                .supplyAsync(() -> task.apply(number1), executorService)
                .thenAccept((n) -> System.out.println("Factorial of " + number1 + " is " + n));

        CompletableFuture
                .supplyAsync(() -> task.apply(number2), executorService)
                .thenAccept((n) -> System.out.println("Factorial of " + number2 + " is " + n));

        executorService.shutdown();

    }
}
