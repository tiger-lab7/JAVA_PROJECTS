public class OutOfMemory {

    public static void main(String... args) {
        outOfMemory();
    }

    static void outOfMemory() {
        Object[][] o = new Object[1000_000][1000_000];
    }
}
