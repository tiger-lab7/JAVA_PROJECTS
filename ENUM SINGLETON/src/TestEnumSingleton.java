public class TestEnumSingleton {
    public static void main(String... args) {

        //Такой Синглтон всегда возвращает один и тот же объект благодаря свойствам enum записей
        new RunEnumSingleton();
        new RunEnumSingleton();

        // Не потокобезопасный синглтон с ленивой инициализацией
        new RunLazyInitSingleton();

        //Запускаем в разных потоках, а работает только 1 Синглтон
        new RunThreadSafeSingletonSimple();

        new RunThreadSafeSingletonLazyInit();

        //К такому Синглтону нужно обращаться через его статический метод класса
        Singleton3.getInstance().doWork();
        Singleton3.getInstance().doWork();

        new RunBillPughSingleton();
    }

}

class RunEnumSingleton {
    static {
        EnumSingleton.INSTANCE.doWork();
    }
}

class RunLazyInitSingleton {

    static {
        for (int i = 0; i < 10; i++)
            new Thread(() -> LazyInitSingleton.getInstance().doWork()).start();
    }
}

class RunThreadSafeSingletonSimple {

    static {
        for (int i = 0; i < 10; i++)
            new Thread(() -> SingletonThreadSafeNotLazy.getInstance().sayHello()).start();
    }
}

class RunThreadSafeSingletonLazyInit {

    static {
        for (int i = 0; i < 10; i++)
            new Thread(() -> SingletonThreadSafeLazyInit.getInstance().doWork()).start();
    }
}

class RunBillPughSingleton {

    static {
        for (int i = 0; i < 10; i++)
            new Thread(() -> BillPughSingleton.getInstance().doWork()).start();
    }
}


