public class Main {

    public static void main(String[] args) {

        try {
            if(Math.random() < 0.5) throw new MyException("Это исключение!");
            else throw new RuntimeException("Runtime exception!");
        }
        catch (RuntimeException ex) {ex.printStackTrace(); System.out.println("Первое исключение!");}
        catch(MyException ex) { ex.printStackTrace(); System.out.println("Второе исключение!"); }

        finally {
            System.out.println("Это обязательно будет напечатано!");
        }

    }
}

class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}
