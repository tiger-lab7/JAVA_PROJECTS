public class Main {

    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        //String input = "A";
        int rows = 3;
        String result = new Solution1().convert(input, rows);
        System.out.println(result);
    }
}
