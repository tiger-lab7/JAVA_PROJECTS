import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static List<File> fileList = new ArrayList<>();

    public static void main(String... args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        File firstFile = new File(filePath);

        dirTraversal(firstFile);

        AtomicInteger counter = new AtomicInteger(0);
        fileList.forEach(n -> {System.out.println(counter + " " + n.getName()); counter.incrementAndGet();});

    }

    private static void dirTraversal(File file) throws IOException {

        if(file.isFile()) {
            fileList.add(file);
            return;
        }

        File[] listDirectory = file.listFiles();

        if(listDirectory == null) return;

        for(File currentFile : listDirectory) {
            if(currentFile.isDirectory()) dirTraversal(currentFile);
            else fileList.add(currentFile);
        }
    }
}
