public class Main {

    public static void main(String... args) {

        int x = 20;
        while (x > 0) {
            do {
                x -= 2;
            }
            while (x > 5);
            x--; System.out.print(x + "\t");
        }


        OUTER_LABEL: for(int i = 0; i < 10; i++) {
            for(int n = 0; n < 5; n++) {
                System.out.println(i + " " + n);
                if(i * n == 21) break OUTER_LABEL;
            }
        }
    }
}
