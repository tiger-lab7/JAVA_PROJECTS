import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {

        try(Reader fileReader = new FileReader("C:/Users/A12/Desktop/Новый текстовый документ.txt")) {
            while(fileReader.ready()) {
                System.out.println(fileReader.read());
            }
        }
    }
}
