// Thread safe Singleton #1
public class SingletonThreadSafeNotLazy {
    //Создаем рекурсивное приватное поле переменной своего же класса
    private static SingletonThreadSafeNotLazy singletonInstance;

    // Приватный конструктор не дает создать объект класса "снаружи"
    private SingletonThreadSafeNotLazy() {
    }

    // Синхронизированный фабричный метод возвращает
    // первый и единственный экземпляр класса Синглтон
    synchronized public static SingletonThreadSafeNotLazy getInstance() {

        if (singletonInstance == null)
            singletonInstance = new SingletonThreadSafeNotLazy();

        return singletonInstance;
    }

    public String sayHello() {
        return "SINGLETON FOR MULTITHREADING IS WORKING! HASH: " +
                singletonInstance.hashCode();
    }
}