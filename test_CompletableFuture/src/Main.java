import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        CompletableFuture<Integer> cf = new CompletableFuture<>();
        cf.supplyAsync(() -> 777)
                .thenCompose(x -> new CompletableFuture<String>().)
    }
}
