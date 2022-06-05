public class JavaThreads {

    public static void main(String... args) {

        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread);
        System.out.println(currentThread.getId());
        System.out.println(currentThread.getName());
        System.out.println(currentThread.getPriority());
        System.out.println(currentThread.getClass());

    }
}
