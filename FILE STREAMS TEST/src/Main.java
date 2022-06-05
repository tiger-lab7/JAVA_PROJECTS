import java.io.*;

public class Main {
    private static byte[] testByteArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String... args) throws IOException {

        File file = new File("D:/Java File Test.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(testByteArray, 0, testByteArray.length);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("D:/Java File Test.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] outputArray = bufferedInputStream.readAllBytes();
        fileInputStream.close();

        for (byte b : outputArray) {
            System.out.println(b);
        }

    }
}
