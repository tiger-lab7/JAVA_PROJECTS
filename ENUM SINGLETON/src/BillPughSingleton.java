// Thread-safe singleton #3

public class BillPughSingleton {

    private BillPughSingleton() {}

    private static class NestedInstanceHolder {
        private static final BillPughSingleton singletonInstance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return NestedInstanceHolder.singletonInstance;
    }

    public void doWork() {
        System.out.println("Bill Pugh Singleton is working... My unique code: " + this.hashCode());
    }
}
