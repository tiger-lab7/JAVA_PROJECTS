
public class NumberPool {

    public static void main(String... args) {
        double n;
        for(long i = 0; i < 4000_000_000L; i++) {
            n = Math.random() * 100;
        }
    }
}
