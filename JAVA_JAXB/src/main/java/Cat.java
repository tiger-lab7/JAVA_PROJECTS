import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Arrays;
import java.util.Objects;

@XmlType(name = "cat", factoryMethod = "getCat")
@XmlRootElement
public class Cat {
    @XmlAttribute(name = "cat_name") // Make field as attribute for upper xml tag
    public String name;

    public int age;

    @XmlJavaTypeAdapter(WeightAdapter.class)
    public Double weight;

    @XmlElementWrapper(name = "preferred_meal", nillable = true) // Wrapper for Collection and Array elements
    public String[] eats;


    private Cat() {
    }

    private Cat(String name, int age, double weight, String[] eats) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.eats = eats;
    }

    public static Cat getCat() {
        return new Cat();
    }

    public static Cat getCat(String name, int age, double weight, String[] eats) {
        return new Cat(name, age, weight, eats);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (age != cat.age) return false;
        if (Double.compare(cat.weight, weight) != 0) return false;
        return Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", eats=" + Arrays.toString(eats) +
                '}';
    }
}
