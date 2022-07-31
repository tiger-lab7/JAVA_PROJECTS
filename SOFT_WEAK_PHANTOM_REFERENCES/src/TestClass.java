public class TestClass {
    int n = 777;

    @Override
    public void finalize() {
        System.out.println("Perform destroying the object");
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "n=" + n +
                '}';
    }
}
