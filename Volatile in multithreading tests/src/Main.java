public class Main {

    public static void main(String[] args) {
        Incrementer incrementer = new Incrementer();

        Runnable callIncrement = () -> {
            try {
                while(true) {
                    incrementer.increment();
                }
            } catch (Exception ex) {ex.printStackTrace();}
        };

        new Thread(callIncrement).start();
        new Thread(callIncrement).start();
    }
}

class Incrementer {
    public volatile long i = 0, j = 0;

    public void increment() throws Exception {
        i++; j++;
        if(i != j) throw new Exception(i + " Не равно " + j);
        if(i == Long.MAX_VALUE && j == Long.MAX_VALUE) throw new Exception("Finish!");
    }
}
