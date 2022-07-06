import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File startDirectory = null;
        while(startDirectory == null || !startDirectory.isDirectory()) {
            System.out.println("Enter start directory");
            startDirectory = new File(sc.nextLine());
        }
        System.out.println("Enter file extension");
        String extension = sc.nextLine();
        System.out.println("Enter substring to search");
        String substring = sc.nextLine();
        SearchFilesEngine.INSTANCE.search_files(startDirectory, extension, substring);
    }
}
