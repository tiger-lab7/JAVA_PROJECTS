import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        TaskClass taskClass = new TaskClass();
        ActionClass actionClass = new ActionClass();

        taskClass.fork();
        String result = taskClass.join();
        System.out.println(result);

        result = forkJoinPool.invoke(taskClass);
        System.out.println(result);
        forkJoinPool.execute(actionClass);
}
}

class TaskClass extends RecursiveTask<String> {

    @Override
    protected String compute() {
        return "I am just a simple class. Thread: "
                    + Thread.currentThread().getName();
    }
}

class ActionClass extends RecursiveAction {

    @Override
    protected void compute() {
        System.out.println("Выполняется действие! Thread: "
                + Thread.currentThread().getName());
    }
}