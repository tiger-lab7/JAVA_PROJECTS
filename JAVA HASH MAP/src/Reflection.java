import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Reflection {

    public static void main(String[] args) throws IllegalAccessException {

        PrivateClass privateClass = new PrivateClass();
        Field field = privateClass.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        String returnString = (String) field.get(privateClass);
        System.out.println(returnString);

        Field field1 = privateClass.getClass().getDeclaredFields()[1];
        field1.setAccessible(true);
        ArrayList<Integer> returnArray = (ArrayList<Integer>) field1.get(privateClass);
        for (Integer integerArrayList : returnArray){
            System.out.println(integerArrayList);
        }
    }
}

class PrivateClass {
    private String secretString = "ВАСЯ ОЧЕНЬ УМНЫЙ";
    private List<Integer> secretList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8)); //Способ наполнения из класса Arrays!
    {
        secretList.add(9); // Такой способ наполнения ArrayList'a оптимален тем, что не создаёт лишних инстансов
        secretList.add(10);
    }
}
