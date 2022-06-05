public class TestObjectHash2 extends TestObject implements Hash2Impl  {
    private final int n;

    public TestObjectHash2(int id, int n) {
        super(id);
        this.n = n;
    }

    // Not-null hash2 method
    @Override
    public int hash2() {
        return id + 31 * (n + 1);
    }
}
