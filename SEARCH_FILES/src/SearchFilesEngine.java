import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public enum SearchFilesEngine {
    INSTANCE;
    private ExecutorService threadPool = Executors.newFixedThreadPool(2);
    public void search_files(File startDirectory, String extension, String substr) {
        Deque<File> directories = new LinkedList<>();
        directories.add(startDirectory);

        while(!directories.isEmpty()) {
            File[] fileList = directories.pop().listFiles();
            if (fileList == null) continue;
            for (File f : fileList) {
                if (f.isDirectory())
                    directories.add(f);
                else if (f.getName().endsWith(extension)) {
                    threadPool.execute(new SearchSubstringInFile(f, substr));
                }
            }
        }
    }
}

class SearchSubstringInFile implements Runnable {
    private final File f;
    private final String substr;

    public SearchSubstringInFile(File f, String substr) {
        this.f = f;
        this.substr = substr.toLowerCase(Locale.ROOT);
    }

    @Override
    public void run() {
        try (FileReader fileReader = new FileReader(f)) {
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String file_str = bufferedReader.lines()
                        .collect(Collectors.joining())
                        .toLowerCase(Locale.ROOT);
                if (file_str.contains(substr))
                    System.out.println(f.getAbsolutePath());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot access to " + f);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
