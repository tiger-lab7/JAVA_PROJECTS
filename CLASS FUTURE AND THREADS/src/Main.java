import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

        public static void main(String... args) throws ExecutionException, InterruptedException {

            Callable task = () -> {
                return "Hello, World!";
            };

            // Оборачиваем Callable или Runnable классом FutureTask
            FutureTask<String> myTask = new FutureTask<>(new Task());

            Thread thread = new Thread(myTask); // Создаём объект потока и передаём в него наш FutureTask
            thread.start(); // Запуск потока всегда методом start()
            // Получаем результат работы метода call в объекте посредством его обёртки FutureTask.get()

            System.out.println(myTask.get());//При получении get() происходит синхронизация

        }


    }

    class Task implements Callable {

        public String call() throws InterruptedException {
            System.out.println("Начало выполнения задачи...");
            Thread.sleep(5000);
            return "Конец выполнения задачи...";
        }
    }

