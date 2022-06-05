import java.util.Stack;

public class JavaQueue {


    public static void main(String ... args) {
        HomeMadeQueue<Integer> myQueue = new HomeMadeQueue<>();
        myQueue.push(777);
        myQueue.push(888);
        myQueue.push(999);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

        HomeMadeQueue<String> myQueue1 = new HomeMadeQueue<>();
        myQueue1.push("КОТ");
        myQueue1.push("ВАСЯ");
        myQueue1.push("СЕРЫЙ");
        System.out.println(myQueue1.pop());
        System.out.println(myQueue1.pop());
        System.out.println(myQueue1.pop());
        System.out.println(myQueue1.pop());
        myQueue1.push("КОТ СЕРЫЙ - ПРЕСЕРЫЙ!");
        myQueue1.push("КОТ ОЧЕНЬ КРАСИВЫЙ!");
        System.out.println(myQueue1.pop());
        System.out.println(myQueue1.pop());



        HomeMadeStack<Integer> myStack = new HomeMadeStack<>();
        for(int i = 0; i < 10000; i++) {
            myStack.push(i);
        }
        for(int i = 0; i < 10002; i++) {
            System.out.println(myStack.pop());
        }

        // Штатный stack в Java
        Stack javaStack = new Stack();
        javaStack.push("КОТЯРА");
        System.out.println(javaStack.pop());



    }

}


