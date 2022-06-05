public class Main {


    public static void main(String[] args) {

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // Пример создания объекта вложенного класса через объект внешнего

        Outer.Nested nested = new Outer.Nested(); // Статический вложенный класс можно создавать так

        inner.readName(); nested.readName(outer);
    }
}


class Outer {
    private String name = "Игорь";
    private final double id = Double.NEGATIVE_INFINITY;

    static class Nested {
        void readName(Outer outerObj) { // Так можно передать ссылку на нестат объект в стат. вложенный метод
            System.out.println("Hello " + outerObj.id);
        }
    }

    public class Inner {
        void readName() {
            System.out.println(name);
        }
    }

}
