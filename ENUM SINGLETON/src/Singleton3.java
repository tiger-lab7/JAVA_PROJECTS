public class Singleton3 {
    // В приватном поле создается единственный экземпляр этого класса не ленивым образом
    private final static Singleton3 singletonInstance = new Singleton3();

    // Приватный конструктор не дает создать объект класса "снаружи"
    private Singleton3() {}

    public static Singleton3 getInstance() {
        return singletonInstance;
    }

    public void doWork() {
        System.out.println("Я СИНГЛТОН 3 ТИПА! МОЙ ХЭШ КОД: " + singletonInstance.hashCode());
    }
}
