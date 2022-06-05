import java.util.function.Supplier;

public class BoundedMethodReference {

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        Printer printer = new Printer();
        printer.print(testClass::someMethod);
    }
}


class Printer {
    public void print(Supplier<String> stringSupplier) {
        System.out.println(stringSupplier.get());
    }
}

class TestClass  {
    public String someMethod() {
        return "Hello!";
    }
}
