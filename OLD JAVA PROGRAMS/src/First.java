

public class First {

    public static void main(String[] args) {

        MyThread threader1 = new MyThread(1);
        MyThread threader2 = new MyThread(2);



        threader1.start();
        threader2.start();


    }
}