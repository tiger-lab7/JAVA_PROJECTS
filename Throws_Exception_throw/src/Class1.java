import javax.security.auth.DestroyFailedException;

public class Class1 {


    public static void main (String[] args) throws Exception { // Здесь мы указываем,\
                          // что данный метод может выбрасывать исключения
                            // и его выполнение будет отменяться в случае исключения



        boolean N = 777 > 666;

        System.out.println(N);


        throw new DestroyFailedException(); // Это команда выбросить исключение
                            // определенного типа



    }
}
