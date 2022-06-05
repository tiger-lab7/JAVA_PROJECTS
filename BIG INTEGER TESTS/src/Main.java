import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger b = BigInteger.valueOf(777L);
        BigInteger d = new BigInteger(1, new byte[] {11, 13}, 0, 2);

        System.out.println(d.toString(10));

    }
}
