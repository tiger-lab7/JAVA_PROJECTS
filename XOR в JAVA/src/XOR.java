public class XOR {

    public static void main(String[] args) {

        boolean A = true;
        boolean B = false;

        // XOR - ЭТО АНТИ-ЭКВИВАЛЕНЦИЯ!
        boolean C = A != B;
        System.out.println(C);

// Битовый оператор ^ подходит для boolean значений в качестве XOR, поскольку boolean  - фактически 1 бит
        C = A ^ B;
        System.out.println(C);

// Прямая реализация. Скобки не нужны,потому что приоритеты: сначала унарные операции - НЕ,
// затем логическое умножение И,
// затем логическое сложение ИЛИ
        C = A && !B || !A && B;
        System.out.println(C);

    }
}
