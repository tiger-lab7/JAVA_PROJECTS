public class Main {

    public static void main(String[] args) throws InterruptedException {

        QueueHM<Integer> queueHM = new QueueHM<>();

        Runnable pusher = () -> {
            for(int i = 0; i < 15; i++) {
                queueHM.pushBack(i);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ignored) {}
            }
        };


        /*Runnable popper = () -> {
            while(true) {
                System.out.println(queueHM.popFront());
            }
        };*/

        Thread thread1 = new Thread(pusher);
        //Thread thread2 = new Thread(popper);
        //thread2.start();
        thread1.start();

        Thread.sleep(1000);

        for(int n : queueHM) {
            System.out.println(n);
        }

    }
}
