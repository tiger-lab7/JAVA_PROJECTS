// Thread-safe singleton #2. Performance boost compared with SingletonForMultithreading.

public class SingletonThreadSafeLazyInit {
    private static SingletonThreadSafeLazyInit singletonInstance;

    private SingletonThreadSafeLazyInit() {}

    public static SingletonThreadSafeLazyInit getInstance() {
        if (singletonInstance == null) {
            synchronized (SingletonThreadSafeLazyInit.class) {
                if (singletonInstance == null)
                    singletonInstance = new SingletonThreadSafeLazyInit();
            }
        }
        return singletonInstance;
    }

    public void doWork() {
        System.out.println("Singleton Thread Safe Lazy Init is working..." +
                " My unique code: " + this.hashCode());
    }
}
