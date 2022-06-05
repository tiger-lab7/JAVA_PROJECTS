public class CLASS_INJECTION {

    public static void main(String ... args) {

        Test_Class testObject = new Test_Class() {

            @Override
            void testFunction() {
                System.out.println("ПРИВЕТ, Я ПЕРЕОПРЕДЕЛЯЮ ФУНКЦИЮ");
            }
        };

        testObject.testFunction();
    }


}

class Test_Class {

    void testFunction() {
        System.out.println("ПРИВЕТ, Я ТЕСТОВАЯ ФУНКЦИЯ");
    }
}

// Как работает переопределение метода в Java.
// При создании объекта в фигурных скобочках, в конце оператора до ;