public class LazyInitSingleton {
    //Создаем рекурсивное приватное поле переменной своего же класса
    private static LazyInitSingleton singleton;

    // Приватный конструктор не дает создать объект класса "снаружи"
    private LazyInitSingleton() {}

    // Статический фабричный метод возвращает первый и единственный экземпляр класса Синглтон
    public static LazyInitSingleton getInstance() {
        if (singleton == null) singleton = new LazyInitSingleton();

        return singleton;
    }

    public void doWork() {
        System.out.println("SINGLETON IS WORKING!" + singleton.hashCode());
    }
}
