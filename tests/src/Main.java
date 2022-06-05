public class Main {

    public static void main(String... args) {

        System.out.println((0 + 15) / 2);
        System.out.println(2.0E-6 * 100000000.1); // 2.0 умножается на 10^-6 и умножается на 100000000.1
        System.out.println(true && false &&  true && true); // левое выражение - всегда false
        System.out.println(true && false ||  true && true); // правое выражение - всегда true

        System.out.println((1 + 2.236) / 2); // Приведение к float
        System.out.println(1 + 2 + 3 + 4.0); // Приведение к float
        System.out.println(4.1 >= 4); // Приведение к float
        System.out.println(1 + 2 + "3"); // Приведение к String

    }
}
