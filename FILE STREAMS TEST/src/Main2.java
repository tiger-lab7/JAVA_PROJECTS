import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main2 {
    static ArrayList<String> findFiles = new ArrayList<>();

    public static void main(String... args) {
        //String path = "F:/DOWNLOADSx64";
        String path = "F:/Program files";
        File pathFile = new File(path);
        fileSearcher(pathFile);
        AtomicInteger number = new AtomicInteger( 0);
        findFiles.forEach(n -> {System.out.println(number + " " + n); number.incrementAndGet();});

    }

    private static void fileSearcher(File pathFile) {

        File[] fileList;
        if(pathFile.isDirectory()) {
            fileList = pathFile.listFiles();
            if(fileList == null) return;
            for(File fileName : fileList) {
                if(fileName.isDirectory()) fileSearcher(fileName);
                else findFiles.add(fileName.getName());
            }
        }

    }
}
