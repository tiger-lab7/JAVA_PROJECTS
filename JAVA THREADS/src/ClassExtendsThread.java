public class ClassExtendsThread {
    public static void main(String... args) throws InterruptedException {

        System.out.println("Main started!");
        for(int i = 0; i < 10; i++) {
            JavaThread jt = new JavaThread("Java Thread " + i);
            jt.start();
            jt.join();
        }
        System.out.println("Main finished!");
    }
}


class JavaThread extends Thread {

    JavaThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try{
            sleep(5000);
        } catch(InterruptedException e) {System.out.println("Thread has been interrupted");}
        System.out.printf("%s finished! \n", Thread.currentThread().getName());
    }


}
