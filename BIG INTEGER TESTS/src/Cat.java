public record Cat (int id, String name) {
    static {
        System.out.println("Static initializer");
    }
}
