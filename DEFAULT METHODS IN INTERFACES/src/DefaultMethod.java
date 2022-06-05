public class DefaultMethod implements FirstInterface {

    public static void main(String... args) {

        //Использовать default методы интерфейса можно только после получения экземпляра

        FirstInterface firstInterface = new FirstInterface(){};

        firstInterface.walker();

        // Использовать static методы интерфейсов можно напрямую, как обычно

        FirstInterface.walker2();
    }
}

interface FirstInterface {

    default void walker() {
        System.out.println("Я иду гулять!");
    }

    static void walker2() {
        System.out.println("Я тоже иду гулять!");
    }
}
