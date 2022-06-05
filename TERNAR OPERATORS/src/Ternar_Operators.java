public class Ternar_Operators {

    public static void main(String[] args) {
        String f = "СОБАКА";

        //String g = "СОБАКА";
        String g = "КОТ";

        String r = f != null && f == g ? f : g;

        System.out.println(r);

        // То же самое с блоками if

        if (f != null && f != g) {
            r = g;
        } else {
            r = f;
        }

        System.out.println(r);

        int[] Ar = new int[6];

        for (int i : Ar) {

            System.out.println(i);

        }


    }
}
