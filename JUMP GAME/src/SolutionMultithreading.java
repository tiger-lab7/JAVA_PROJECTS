import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SolutionMultithreading {
    private int[] nums;
    private int lastIndex;
    private NavigableSet<Integer> resultSet = new ConcurrentSkipListSet<>();
    private ExecutorService executorService = Executors.newFixedThreadPool(4);
    private AtomicInteger activeThreads = new AtomicInteger(0);


    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        this.nums = nums;
        lastIndex = nums.length - 1;
        jumper(new AtomicInteger(0), new AtomicInteger(0));
        //while(activeThreads.get() > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
           // }
        }

        executorService.shutdown();
        resultSet.forEach(System.out::println);
        return resultSet.pollFirst();

    }

    private void jumper(AtomicInteger startIndexAtom, AtomicInteger jumpCountAtom) {
        System.out.println(Thread.currentThread().getId());
        activeThreads.incrementAndGet();
        int startIndex = startIndexAtom.get();

        if(nums[startIndex] == 0) {
            activeThreads.decrementAndGet();
            return;
        }

        jumpCountAtom.incrementAndGet();

        int jumpMaxIndex = startIndex + nums[startIndex];

        if(jumpMaxIndex >= lastIndex) {
            resultSet.add(jumpCountAtom.get());
            activeThreads.decrementAndGet();
            return;
        }

        for(int i = jumpMaxIndex; i > startIndex; i--) {
            startIndexAtom.set(i);

            executorService.submit(() -> {
                    jumper(startIndexAtom, jumpCountAtom);});
        }
    }
}
