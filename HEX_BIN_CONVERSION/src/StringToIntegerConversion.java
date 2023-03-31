public class StringToIntegerConversion {

    public static void main(String[] args) {

        String hexString = "fffaaaa";

        int number1 = Integer.parseInt(hexString, 16);
        System.out.println(number1);

        String binaryString = "1111110011001000110101010";
        long number2 = Long.parseLong(binaryString, 2);
        System.out.println(number2);
    }
}
