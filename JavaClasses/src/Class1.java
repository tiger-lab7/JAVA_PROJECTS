import java.sql.SQLDataException;

public class Class1 {

    public static void main(String[] args)  {

        System.out.println("Hello!");

        Class2.function2(); //Прямое обращение к static - методу другого класса!

        Class2 object = new Class2();

        object.function2(); // Обращение к методу объекта - экземпляра класса Class2
    }
}

class Class2 {

    public Class2 () {
        System.out.println("Hi!!!!!");
    }

    public static void function2()  {

        System.out.println("Hi again!");


    }
}