import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        Test test = new Test();

        /* Обращаемся к вложенному интерфейсу класса для получения типа
           возвращаемого фабрикой shellMethod объекта, соответствующего
           универсальному вложенному интерфейсу  */
        Test.classInterface testClassInterfaceObject = test.shellMethod(15);
        System.out.println(testClassInterfaceObject.result(10));

        /* Если аргумент shellMethod < 10, метод возвращает другой объект, но соответсвующий
           вложенному интерфейсу classInterface, что позволяет вызвать у возвращенного объекта
           результ идентичным образом, путем использоввания метода .result() */
        Test.classInterface testClassInterfaceObject2 = test.shellMethod(5);
        System.out.println(testClassInterfaceObject2.result(10));
    }

}

class Test {
    interface classInterface {
        int result(int x);
    }

    public classInterface shellMethod(int x) {

        class InnerClass1 implements classInterface{
            @Override
            public int result(int y) { return x * y; }
        }
        class InnerClass2 implements classInterface {
            @Override
            public int result(int z) { return x * z * 10; }
        }

        classInterface resultObject;
        if(x > 10) resultObject = new InnerClass1();
        else resultObject = new InnerClass2();

        return resultObject;
    }
}
