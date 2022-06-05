public class UnboundedMethodReference {

    public static void main(String[] args) {
        Runner runner = new Runner();

        GenericPrinter<Integer> genericPrinter = new GenericPrinter<>();

        runner.run(genericPrinter::hello1, 777);
        runner.run(genericPrinter::hello2, 888);

    }
}

interface GenericMethod<T extends Number> {
    String helloNumber(T number);
}

class GenericPrinter<T extends Number> {
    public String hello1(T number) {
        return "Hello " + number;
    }
    public String hello2(T number) {
        return "Hi " + number;
    }
}

class Runner {
    public <T extends Number> void run(GenericMethod<T> method, T number) {
        String result = method.helloNumber(number);
        System.out.println(result);
    }
}