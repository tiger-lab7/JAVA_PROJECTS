import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA256 {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        byte[] digest = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        String hash = bytesToHex(digest);
        System.out.println(hash);


    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
