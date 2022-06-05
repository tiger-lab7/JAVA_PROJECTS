import java.util.function.Function;
import java.util.function.Supplier;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(returnLambda(2).apply(0));
        System.out.println(returnMethod(1).get());
        TestDynamic testDynamic = new TestDynamic();
        System.out.println(testDynamic.returnMethod(2).get());
    }

    static Function<Integer, String> returnLambda(int i) {
        // Здесь происходит замыкание контекста i и лямбда в дальнейшем будет возвращать только одно значение
        return x -> {
            if(i == 1) return "Кот Вася";
            if(i == 2) return "Кот Барсик";
            return "";
        };
    }

    static Supplier<String> returnMethod(int i) {
        if(i == 1) return Main2::method1;
        return Main2::method2;
    }

    static String method1() {
        return "Кот 1";
    }
    static String method2() {
        return "Кот 2";
    }
}

class TestDynamic {

    private String method1() {
        return "Динамический метод 1!";
    }
    private String method2() {
        return "Динамический метод 2!";
    }
    public Supplier<String> returnMethod(int i) {
        if(i == 1) return this::method1;
        return this::method2;
    }
}
