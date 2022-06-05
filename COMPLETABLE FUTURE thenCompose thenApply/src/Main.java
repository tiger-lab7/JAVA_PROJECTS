import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final int[] n = {100};
        Runnable lambdaTask = () -> { n[0] *= n[0]; };

        Supplier<String> stringSupplier1 = () -> {return "Привет, я кот Вася!";};
        Supplier<String> stringSupplier2 = () -> {return "Привет, я кот Оливер!";};

        CompletableFuture<String> completableFuture1 = new CompletableFuture<>();
        CompletableFuture<String> completableFuture2 = new CompletableFuture<>();

        completableFuture1.completeAsync(stringSupplier1);
        Thread.sleep(100);
        completableFuture2.completeAsync(stringSupplier2);

        CompletableFuture<String> resultCombine = completableFuture1
                .thenCombine(completableFuture2, (str1, str2) -> {
                    System.out.println("Completed!");
                    return str1 + " " + str2;});

        System.out.println(resultCombine.get());

        CompletableFuture<String> completableFuture3 =
                CompletableFuture.supplyAsync(stringSupplier1)
                .thenCompose(str -> CompletableFuture.supplyAsync(() -> "Умнейший " + str))
                .thenCompose(str -> CompletableFuture.supplyAsync(() -> str + " добрейший"));

        System.out.println(completableFuture3.get());

        CompletableFuture<String> completableFuture4 =
                CompletableFuture.supplyAsync(() -> "Кот Барсик")
                .thenApplyAsync(str -> str + " мягчайший");
        System.out.println(completableFuture4.get());

    }
}
