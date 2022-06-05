public class StaticLearning {

    public static void main(String... args) {
        Statificator statificator1 = new Statificator();
        Statificator statificator2 = new Statificator();
        statificator1.ClassMethod();
        //statificator1.universalStaticMethod();
        statificator2.ClassMethod();
        //statificator2.universalStaticMethod();
        System.out.println(Statificator.string1);

    }
}

class Statificator {

    static String string1 = "ЕДИНАЯ СТРОКА ДЛЯ ВСЕХ";

    static void universalStaticMethod() {
        System.out.println("ПИШУ ЭТО В ЛЮБОМ ЭКЗЕМПЛЯРЕ КЛАССА!");
    }

    static { //Этот блок инициализации выполняется всегда при любом обращении к классу! В.т.ч к его static переменным!
        //Java хранит классы в виде байт-кода и загружает их когда они востребованы. 1 раз!
        int randomNumber = (int) (java.lang.Math.random() * 1000);
        System.out.println("Я STATIC БЛОК ИНИЦИАЛИЗАЦИИ КЛАССА! " + randomNumber);
    }

    {  // Такой блок инициализации выполняется всегда при создании объекта, по сути это универсальный конструктор
        int randomNumber = (int) (java.lang.Math.random() * 1000);
        System.out.println("Я БЛОК ИНИЦИАЛИЗАЦИИ ЭКЗЕМПЯРА! " + randomNumber);
    }

    void ClassMethod() {
        System.out.println(java.lang.Math.random() + " ЭТО РАНДОМНОЕ ЧИСЛО УНИКАЛЬНО ДЛЯ КАЖДОГО ЭКЗЕМПЛЯРА");
        string1 = "МЕНЯЮ ЗНАЧЕНИЕ СТРОКИ И ПОЛУЧАЮ ХЭШ КОД ЭКЗЕМПЛЯРА " + this.hashCode();
        System.out.println(string1);

    }
}
