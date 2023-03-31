public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.recursiveMethod();
        System.out.println("Hello world!");
    }

    void recursiveMethod() {
        recursiveMethod();
    }
}