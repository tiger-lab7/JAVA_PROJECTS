interface TestStaticInInterface {

    static final int T = 100;

    static void testStaticMethod() {
        System.out.println("ТЕСТ СТАТИЧЕСКОГО МЕТОДА В ИНТЕРФЕЙСЕ!");
    }

    default void testDefaultMethod() {
        System.out.println("ТЕСТ ДЕФОЛТНОГО МЕТОДА В ИНТЕРФЕЙСЕ!");
    }
}

public class InterfacesInJava implements TestStaticInInterface {

    public static void main(String... args) {

        TestStaticInInterface testStaticInInterface = new InterfacesInJava();
        testStaticInInterface.testDefaultMethod();

        TestStaticInInterface.testStaticMethod();//Обращаемся к static методу в интерфейсе напрямую

        System.out.println(TestStaticInInterface.T);

        Test111 test111 = new Test111();
        test111.testDefaultMethod();
    }
}

class Test111 implements TestStaticInInterface {
    @Override
    public void testDefaultMethod() {
        System.out.println("ТЕСТ МЕТОДА КЛАССА ИМПЛЕМЕНТИРУЮЩЕГО ИНТЕРФЕЙС");
    }
}
