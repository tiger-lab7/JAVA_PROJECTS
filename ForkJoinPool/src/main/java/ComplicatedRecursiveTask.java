import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ComplicatedRecursiveTask {

        public static void main(String[] args) {
            int[] array = getInitArray(100);
            ValueSumCounter counter = new ValueSumCounter(array);
            System.out.println(new Date());
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            System.out.println(forkJoinPool.invoke(counter));
            System.out.println(new Date());
        }

        public static int[] getInitArray(int capacity) {
            int[] array = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                array[i] = 3;
            }
            return array;
        }
}

class ValueSumCounter extends RecursiveTask<Integer> {

    private int[] array;

    public ValueSumCounter(int[] array) {
        System.out.println(Thread.currentThread().getName() + " started!");
        this.array = array;
    }

    @SneakyThrows
    @Override
    protected Integer compute() {
        if(array.length <= 2) {
            Thread.sleep(1);
            return Arrays.stream(array).sum();
        }
        ValueSumCounter firstHalfArrayValueSumCounter
                = new ValueSumCounter(Arrays.copyOfRange(array, 0, array.length/2));
        ValueSumCounter secondHalfArrayValueSumCounter
                = new ValueSumCounter(Arrays.copyOfRange(array, array.length/2, array.length));
        firstHalfArrayValueSumCounter.fork();
        secondHalfArrayValueSumCounter.fork();
        return firstHalfArrayValueSumCounter.join() + secondHalfArrayValueSumCounter.join();
    }
}
