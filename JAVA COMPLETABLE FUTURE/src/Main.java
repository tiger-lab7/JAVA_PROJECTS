import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String... args) throws ExecutionException, InterruptedException {

        //CompletableFuture - это объект, в отличие от простого интерфейса Future
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        completableFuture.completeAsync(() -> "New String")
                .thenAccept(s -> {System.out.println(s + " in lambda " + Thread.currentThread().getName());})
                .whenComplete((s, except) -> System.out.println("OK " + s)).get();


        /* CompletableFuture имеет встроенный Executor и может асинхроно запускать совершенно разные задачи
        * Чтобы заставить thenRunAsync выполняться в разных потоках, нужно дополнительно
        * передать отдельный Executor для него */
        completableFuture
                .thenRunAsync(new Factorial(1000L), Executors.newSingleThreadExecutor())
                .thenRunAsync(() -> new Thread(new Factorial(500L)).start())
                .get();

        //new Factorial().run();

    }
}

class Factorial implements Runnable {
    private long number = 1L;
    Factorial(long number) {this.number = number;}

    @Override
    public void run() {
        BigInteger factorial = BigInteger.valueOf(1);

        for(long i = 1; i < number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial + " выполнен в потоке: " + Thread.currentThread().getName());
    }
}
