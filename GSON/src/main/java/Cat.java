import java.util.Arrays;
import java.util.List;

public class Cat {
    String name;
    int age;
    String[] eat;
    List<String> habits;
    double weight;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", eat=" + Arrays.toString(eat) +
                ", habits=" + habits +
                ", weight=" + weight +
                '}';
    }
}
