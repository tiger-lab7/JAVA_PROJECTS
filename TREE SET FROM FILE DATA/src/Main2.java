import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Main2 {
    private static String filePath = "C:/Users/A12/Desktop/БЛОКНОТЫ ПРОГРАММИРОВАНИЕ/ПРОГРАММИРОВАНИЕ НА JAVA.txt";
    //private static String filePath ="C:/Users/A12/Desktop/БЛОКНОТЫ ПРОГРАММИРОВАНИЕ/SQL.txt";
    private static Set<String> stringSet = new TreeSet<>((str1, str2) -> str1.compareToIgnoreCase(str2));
    private static String regex = "[абвгдеёжзийклмнопрстуфхцчшщъьыэюя]";

    public static void main(String... args) throws IOException {

        FileReader fileReader = new FileReader(filePath);
        String encoding = fileReader.getEncoding();
        System.out.println("Кодировка файла: " + encoding);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        System.setProperty("file.encoding", encoding);

        String bigString = bufferedReader.lines()
                .map(str -> {
                    String a = str.toLowerCase(Locale.ROOT);
                    if (a.matches(regex)) return a;
                    else return " ";
                    //return  a;
                })
                .collect(Collectors.joining());

        System.out.println("Длина прочитанной строки " + bigString.length());

        FileWriter fileWriter = new FileWriter("D:/DICTIONARY.txt");

        fileWriter.write(bigString);

        ArrayList<String> wordArray = new ArrayList<>(Arrays.asList(bigString.split("\s")));

        stringSet.addAll(wordArray);

        stringSet.forEach(System.out::println);

        System.out.println("Количество слов: " + stringSet.size());
    }
}
