import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class Main1 {

    public static void main(String... args) throws InterruptedException {

        // Создаём объект CompletableFuture
        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();

        Supplier<String> myTask = () -> {
            try {
                return Writer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Нет результата!";
        };


        stringCompletableFuture.completeAsync(myTask)
                                .thenRun(() -> System.out.println("Runnable"));

    }

    static String Writer() throws InterruptedException {
        for(int i = 10; i > 0; i--) {
            System.out.println("Выполнение задачи Writer, осталось: " + i);
            Thread.sleep(2000);
        }
        return "Задача Writer выполнена!";
    }
}

class Task1 implements Callable {

    @Override
    public String call() {
        return Thread.currentThread().getName() +  " Задача выполнена!";
    }
}
