import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;


public class Main {
    //private static String filePath = "C:/Users/A12/Desktop/¡ÀŒ ÕŒ“€ œ–Œ√–¿ÃÃ»–Œ¬¿Õ»≈/œ–Œ√–¿ÃÃ»–Œ¬¿Õ»≈ Õ¿ JAVA.txt";
    //private static String filePath ="C:/Users/A12/Desktop/¡ÀŒ ÕŒ“€ œ–Œ√–¿ÃÃ»–Œ¬¿Õ»≈/SQL.txt";
    private static Set<String> stringSet = new TreeSet<>((str1, str2) -> str1.compareToIgnoreCase(str2));

    public static void main(String... args) throws IOException {

        String path = "C:/Users/A12/Desktop/dialog";
        ArrayList<File> fileArrayList = FileDirectoryReader.readDirectory(path);

        ArrayList<StringBuilder> bigStringArray = new ArrayList<>();
        for (File file : fileArrayList) {
            bigStringArray.add(FileParser.parseFile(file));
        }

        ArrayList<ArrayList<String>> stringArrayList = new ArrayList<>();
        for (StringBuilder bigStringBuilder : bigStringArray) {
            stringArrayList.add(WordParser.parseWords(bigStringBuilder));
        }

        for (ArrayList<String> wordArray : stringArrayList) {
            stringSet.addAll(wordArray);
        }

        stringSet.forEach(System.out::println);

        System.out.println(" ÓÎË˜ÂÒÚ‚Ó ÒÎÓ‚: " + stringSet.size());

        FileWriter fileWriter = new FileWriter("D:/DICTIONARY.txt");
        fileWriter.flush();

        stringSet.forEach(str -> {
            try {
                fileWriter.write(str + " ");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        fileWriter.close();

    /*StringBuilder resultDictionary = new StringBuilder();
    resultDictionary = stringSet.stream()
            .map(str -> str + " ")
            .map(str -> new StringBuilder(str))
            .reduce((accum, strBldr) -> accum.append(strBldr))
            .get();

    StringBuilderWriter.writeStringBuilder(resultDictionary);
    */

    }

}
