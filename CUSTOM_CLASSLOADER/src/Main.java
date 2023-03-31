import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> loadedClass = new CustomClassloader().loadClass();

        //Field loadedClassField = loadedClass.getDeclaredField("name");
        Method loadedClassMethod = loadedClass.getMethod("getName", null);
        System.out.println(loadedClassMethod.invoke(loadedClass., null));
    }
}