import java.io.File;
import java.util.ArrayList;

public class FileDirectoryReader {

    public static ArrayList<File> readDirectory(String path) {

        File folder = new File(path);

        ArrayList<File> outputArray = new ArrayList<>();

        for(File fileEntry : folder.listFiles()) {
            outputArray.add(fileEntry);
        }

        return outputArray;
    }

}
