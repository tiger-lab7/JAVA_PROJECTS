public class LambdaApp {

    public static void main(String[] args) {

        AnonInterface anonObject = new AnonInterface(){

            public int calculate(int x, int y){

                return x + y;
            }
        };
        int z = anonObject.calculate(200, 100);
        System.out.println(z);
    }
}
interface AnonInterface {
    int calculate(int x, int y);
}
/* По факту лямбда-выражения являются в некотором роде
сокращенной формой внутренних анонимных классов, которые
ранее применялись в Java. */