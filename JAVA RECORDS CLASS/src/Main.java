public class Main {

    public static void main(String... args) {
        PlainClass plainClass = new PlainClass(888, "ТИГРИС");
        System.out.println(plainClass);

        FirstRecord firstRecord = new FirstRecord(1, "Васисуалий");
        System.out.println(firstRecord.number() + " " + firstRecord.name());

        SecondRecord secondRecord = new SecondRecord(0, "Барс");
        System.out.println(secondRecord.number() + " " + secondRecord.name());

        ThirdRecord thirdRecord = new ThirdRecord(5, "кот");
        System.out.println(thirdRecord.number() + " " + thirdRecord.name() + " " + thirdRecord.Test());

    }
}

//Простая запись
record FirstRecord(int number, String name) {}

// Запись с переопределённым каноническим конструктором в упрощённой форме
record SecondRecord(int number, String name) {
    SecondRecord{
    if(number == 0) number = 777;
    }
}
// Запись с полностью переопределённым констркутором
record ThirdRecord(int number, String name) {
    ThirdRecord(int number, String name) {
        if (name == "кот") name = "Хороший кот";
        this.number = number;
        this.name = name;
    }
    static {System.out.println("Класс инициализирован!");}
    public int Test() {return 9090;}
}

/*Ограничения records
Следует учитывать, что мы не можем наследовать запись record от других классов.
Также нельзя наследовать классы от records.
Однако классы record могут реализовать интерфейсы.
Кроме того, классы record не могут быть абстрактными.
В record нельзя явным образом определять нестатические поля и инициализаторы.
Можно определять статические переменные и инициализаторы.
Можно определять статические и нестатические методы
 */

