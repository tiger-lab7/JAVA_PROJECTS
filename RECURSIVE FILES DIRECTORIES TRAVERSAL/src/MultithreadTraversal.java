/*
This class represents multithreading search for all files in provided root directory and its subdirectories.
The class uses recursive algorithm with creating new thread for each new directory. Executing of these threads
are provided by ExecutorService and Executors class with number of active threads in Pool is 4, for example.
 */
import java.io.File;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadTraversal {
    public static final int THREAD_POOL = 4;

    public static List<File> fileList = new CopyOnWriteArrayList<>();
    public static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
    public static AtomicInteger activeThreads = new AtomicInteger(0);

    public static void main(String... args) throws InterruptedException {

        // Input top file directory path with checking
        File file;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the directory to multithreading search of all files...");
            String filePath = scanner.nextLine();
            file = new File(filePath);
        } while(!file.isDirectory());

        // Executing first thread
        executorService.execute(new DirTraversal(file));

        // Checking number of active threads and sleep
        while(activeThreads.get() > 0) {
            Thread.sleep(10);
        }
        executorService.shutdown();

        // Print results
        AtomicInteger counter = new AtomicInteger(0);
        fileList.forEach(n -> {System.out.println(counter + " " + n.getName()); counter.incrementAndGet();});

    }
}

class DirTraversal implements Runnable {
    private final File firstFile;

    DirTraversal(File firstFile) {
        this.firstFile = firstFile;
        MultithreadTraversal.activeThreads.incrementAndGet(); // +1 to active scheduled threads counter
    }

    @Override
    public void run() {

        File[] listDirectory = firstFile.listFiles();

        if(listDirectory == null) {
            MultithreadTraversal.activeThreads.decrementAndGet(); // -1 to threads counter if the directory is empty
            return;
        }

        for(File currentFile : listDirectory) {
            if(currentFile.isDirectory()) MultithreadTraversal
                    .executorService
                    .execute(new DirTraversal(currentFile)); // new recursive call thread for an each find directory
            else MultithreadTraversal.fileList.add(currentFile);
        }

        MultithreadTraversal.activeThreads.decrementAndGet(); // -1 to threads counter after dir traversal complete
    }
}

