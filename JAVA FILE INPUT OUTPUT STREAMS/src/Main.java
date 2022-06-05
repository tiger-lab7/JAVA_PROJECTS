import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:/Users/A12/Desktop/Новый текстовый документ.txt");

            byte[] array = new byte[200];
            int numberBytes = fileInputStream.read(array); //Считываем до 200 байтов в массив и возвращаем число считанных байт
            String output = new String(array, "Windows-1251");
            System.out.println(numberBytes + " " + output );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        finally { try {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (IOException e) {e.printStackTrace();}
        }

    }
}
