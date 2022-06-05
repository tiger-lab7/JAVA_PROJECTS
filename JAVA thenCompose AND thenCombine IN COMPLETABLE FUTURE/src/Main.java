import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class Main {

    public static void main(String... args) throws ExecutionException, InterruptedException {

        Supplier<Integer> p1 = () -> (Integer) 100;
        Supplier<Integer> p2 = () -> (Integer) 200;

        CompletableFuture<Integer> completableFuture1 = new CompletableFuture<>();
        CompletableFuture<Integer> completableFuture2 = new CompletableFuture<>();

        completableFuture1.completeAsync(p1);
        completableFuture2.completeAsync(p2);


        //completableFuture1.thenCombine(completableFuture2, (Integer res1, Integer res2) -> res1 + res2);

        completableFuture1.thenCompose();

        Integer result = completableFuture1.get();

        System.out.println(result);

    }
}
