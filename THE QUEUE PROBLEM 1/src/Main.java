/* THE QUEUE PROBLEM №1
 * Two threads  reads the front value of a queue and pop it immediately after.
 * [ QUESTION ] : Does the two threads together always retrieve all the elements of the queue?
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.IntStream;

public class Main {

    public static void main(String... args) {

        Test test = new Test();
        test.testConcurrency();
    }
}


class Test {
    void testConcurrency() {
        Queue<Integer> testQueue = new ConcurrentLinkedDeque<>();
        IntStream.iterate(0, n -> ++n).limit(50).forEach(testQueue::add);

        Runnable retrieveAndDelete = () -> {
            //synchronized (testQueue) {
                while (!testQueue.isEmpty()) {
                    int i = testQueue.remove();
                    System.out.println("Thread " + Thread.currentThread().getId() + " element " + i);

                }
           // }
        };

        Thread thread1 = new Thread(retrieveAndDelete);
        Thread thread2 = new Thread(retrieveAndDelete);

        thread1.start();
        thread2.start();
    }
}
