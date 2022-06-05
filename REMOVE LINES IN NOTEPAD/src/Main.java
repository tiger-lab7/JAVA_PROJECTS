import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        String path1 = "C:/Users/A12/Desktop/ÁËÎÊÍÎÒÛ ÏĞÎÃĞÀÌÌÈĞÎÂÀÍÈÅ/ÏĞÎÃĞÀÌÌÈĞÎÂÀÍÈÅ ÍÀ JAVA.txt";
        String path2 = "C:/Users/A12/Desktop/ÁËÎÊÍÎÒÛ ÏĞÎÃĞÀÌÌÈĞÎÂÀÍÈÅ/ÏĞÎÃĞÀÌÌÈĞÎÂÀÍÈÅ ÍÀ JAVA1.txt";
        NotepadCleaner notepadCleaner = new NotepadCleaner(path1, path2);

    }
}

class NotepadCleaner {

    static {System.out.println("Êëàññ èíèöèàëèçèğîâàí!");}

    public NotepadCleaner(String path1, String path2) throws Exception {
        clean(path1, path2);
    }

    public void clean(String filePath, String filePath2) throws Exception {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()) {
                stringBuilder.append((char)bufferedReader.read());
            }
            String dataString = stringBuilder.toString();
            Pattern pattern = Pattern.compile("[\\n]{4}");
            Matcher matcher = pattern.matcher(dataString);
            dataString = matcher.replaceAll("  _________  ");
            //dataString = dataString.replaceAll("\\n{5,}","\\n\\n\\n\\n\\n");

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath2));
            bufferedWriter.write(dataString);

            bufferedReader.close();
            bufferedWriter.close();
    }

    @Override
    public void finalize(){
        System.out.println("Êëàññ ñåé÷àñ áóäåò óíè÷òîæåí!");
    }

}
