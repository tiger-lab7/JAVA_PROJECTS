public class JavaEnumsMethods {

    public static void main(String... args) {



        // каждый enum имеет встроенный метод values возвращающий массив элементов типа класса Enum
        Cats[] catsValues = Cats.values();

        for(Cats cts : catsValues) {
            System.out.println(cts);
        }

        // Можно использовать массив, даваемый Enum.values()  в качестве итерируемого объектадля цикла foreach
        for(Cats cts : Cats.values()) {
            System.out.println(cts);
        }

        // Enum.valueOf возвращает константу перечислимого типа, соответсвующую введёной строке
        Cats cat = Cats.valueOf("Barsik");

        System.out.println(cat);

        System.out.println("Порядковый номер кота Барсика " + cat.ordinal());
        System.out.println("Соотношение с номером кота Пушка " + cat.compareTo(Cats.Pushok));
    }
}
