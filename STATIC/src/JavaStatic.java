public class JavaStatic {

    public static void main(String... args) {


        System.out.println(Test1.k);
        //Обращение к полю static напрямую через Имя класса.имя переменной

        Test1.test();
        Test1.test2();

        Test1.NestedClass innerClass = new Test1.NestedClass();
        innerClass.nestedActivated();

        var dynamicObjectTest1 = new Test1();
        dynamicObjectTest1.innerClassActivator();
    }

}

