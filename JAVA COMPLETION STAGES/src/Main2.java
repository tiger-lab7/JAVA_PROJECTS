import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main2 {

    public static void main(String... args) throws InterruptedException {
        /* Лямбды, аналогично анонимным и вложенным классам, имеют доступ ко всем переменным
        внешнего класса, поэтому блок захвата [](){} как в C++ здесь не нужен */
        int n = 100;

        /* Атомные переменные глобальны для потоков. Используются для счетчиков
        и не предназначены для замены обычных Integer */
        AtomicInteger result = new AtomicInteger(0);

        Runnable runnableLambda = () -> {
            result.addAndGet(n); // замыкание на n
            System.out.println(result + " " + Thread.currentThread().getName());
        };

        //Класс Thread принимает в конструктор переменную интерфейса Runnable
        Thread thread1 = new Thread(runnableLambda);
        // Класс Thread требует вызвать метод start для запуска переданного ему Runnable!
        thread1.start();

        // Запускаем ещё один поток
        new Thread(runnableLambda).start();

        // Текущий поток main можно приостановить таким образом
        Thread.sleep(1000);

        new Thread(runnableLambda).start();
        new Thread(runnableLambda).start();

        Thread.sleep(1000);

        // Класс Executors создаёт отдельный пул выполнения потоков, независимый от текущего
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(runnableLambda);
        executorService.shutdown();

        System.out.println(result);


    }
}
