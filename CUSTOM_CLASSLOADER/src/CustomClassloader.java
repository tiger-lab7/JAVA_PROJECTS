import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassloader extends ClassLoader{
    public Class<?> loadClass() throws IOException, ClassNotFoundException {
        byte[] byteCodeClass = new FileInputStream("MyClass/Cat.class").readAllBytes();
        Class<?> loadedClass = super.defineClass("Cat", byteCodeClass, 0, byteCodeClass.length);
        super.loadClass("Cat");
        return loadedClass;
    }
}
