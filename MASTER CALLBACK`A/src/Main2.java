import javax.swing.*;

class SomeClass2 {

    String replyTo;

    interface Callback{
        void callingBack(String s);
    }

    private Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    void doSomething(){
        int reply = JOptionPane.showConfirmDialog(null, "Вы программист?", "Опрос", JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.NO_OPTION){
            replyTo = "Нет";
        }
        if (reply == JOptionPane.YES_OPTION){
            replyTo = "Да";
        }

        callback.callingBack(replyTo);
    }
}

class MyClass2 implements SomeClass2.Callback {
    @Override
    public void callingBack(String s) {

        if (s != null) {
            System.out.println("Ваш ответ: " + s);
        } else {
            System.out.println("Вы не ответили на вопрос!");
        }
    }
}

public class Main2 {

    public static void main(String[] args) {

        SomeClass2 someClass2 = new SomeClass2();
        MyClass2 myClass2 = new MyClass2();

        someClass2.registerCallBack(myClass2);
        someClass2.doSomething();
    }
}

