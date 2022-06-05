import java.util.Stack;

class Evaluate {

public static double evaluate(String expr) {
        Stack<String> ops = new Stack<>();
        Stack<Double> values = new Stack<>();

        Outer:
        for (int n = 0; n < expr.length() - 1; n++) { // Чтение элемента и вталкивание его в стек, если это операция.

            String s = expr.substring(n, n + 1);

            switch (s) {
                case ("(") -> {  }
                case ("=") -> { break Outer; }
                case ("+"), ("-"), ("*"), ("/") -> ops.push(String.valueOf(s));

                case (")") -> { // Если ")", то выталкивание, вычисление и вталкивание результата.
                    String op = ops.pop();
                    double v = values.pop();
                    switch (op) {
                        case "+" -> v = values.pop() + v;
                        case "-" -> v = values.pop() - v;
                        case "*" -> v = values.pop() * v;
                        case "/" -> v = values.pop() / v;
                    }
                    values.push(v);
                }
                // Если символ не операция и не скобка: вталкиваем значение double
                default -> {
                    if (!values.isEmpty()) values.push(values.pop() + Double.parseDouble(s));
                    else values.push(Double.parseDouble(s));
                }
            }
        }
        // В конце в стеке values должно оставаться одно значение - результат вычисления выражения
        return values.pop();
    }
}