public class Main {


    public static void main(String[] args) {

        new Task("первый поток").start();
        new Task("второй поток").start();

    }
}

class Task extends Thread {
    // Класс ThreadLocal обеспечивает единое хранилище переменных для каждого потока
    public static final ThreadLocal<String> threadName = new ThreadLocal<>();

    Task(String name) {
        super(name);
    }

    @Override
    public void run() {
        threadName.set(Thread.currentThread().getName());
        System.out.println("Имя потока: " + threadName.get());
    }
}