import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        try {

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(input.getBytes(StandardCharsets.UTF_8));
            byte[] digest = messageDigest.digest();
            String myHash = toHex(digest);

            System.out.println(myHash);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    public static String toHex(byte[] input) {
        return String.format("%x", new BigInteger(1, input));
    }

}
