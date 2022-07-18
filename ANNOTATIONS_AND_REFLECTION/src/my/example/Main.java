package my.example;

import java.lang.reflect.Method;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws NoSuchMethodException {

        SomeClass someClass = new SomeClass();
        Method method = someClass.getClass().getDeclaredMethod("doAction");
        Cool annotation = method.getAnnotation(Cool.class);
        System.out.println(annotation.level()
                + " " + Arrays.toString(annotation.tags())
                + " " + annotation.description());
    }
}




