public class IntegerToStringConversion {
    public static void main(String[] args) {

        int number = 1777;
        System.out.println(number);

        String hexString = Integer.toHexString(number);
        System.out.println(hexString);

        String binaryString = Integer.toBinaryString(number);
        System.out.println(binaryString);
    }
}