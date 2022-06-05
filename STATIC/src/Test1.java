public class Test1 {

    static {
        int i = 100;
        i *= 100;
        System.out.println(i);
    }

    protected static int k = 20000;
    private static String hello = "ПРИВЕЕЕТ!";
    private static String nestedHello = "СТРОКА ДЛЯ ВЛОЖЕННОГО КЛАССА";

    static void test() {
            int k = 999;
            System.out.println(k);
    }

    static void test2() {
        class LocalClass {  //Это Локальный класс метода
            private int k = 2020;
            static final String cool = " Я МОГУ ИМЕТЬ STATIC FINAL ПОЛЯ (Т.Е. НЕИЗМЕНЯЕМЫЕ КОНСТАНТЫ)";
            //Но в целом Локальный класс,как и внутренний и анонимный классы, не может объявлять static методы и поля
            public int getInt(){
                System.out.println(hello + cool); // Имеет доступ к private полям внешнего класса. Больше чем просто наследник!
                return k;
            }
        }
        LocalClass localClass = new LocalClass();
        System.out.println(localClass.getInt());
        //Объект локального класса не может создаваться за пределами метода или блока, в котором его объявили.
    }

    static class NestedClass{

        void nestedActivated() {
            System.out.println("ВЛОЖЕННЫЙ КЛАСС АКТИВИРОВАН!!!" + nestedHello);
        }
    }

    class InnerClass{

        void innerActivated() {
            System.out.println("ВНУТРЕННИЙ КЛАСС АКТИВИРОВАН!!!");
        }
    }

    void innerClassActivator() {
        var innerClass = new InnerClass();
        innerClass.innerActivated();
    }


}