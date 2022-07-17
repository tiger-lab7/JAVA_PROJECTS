import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(name = "cat", factoryMethod = "getCat")
@XmlRootElement  // Necessarily
@EqualsAndHashCode // for testing
public class Cat {
    @XmlAttribute(name = "cat_name") // Make field as attribute for upper xml tag
    public String name;

    public int age;

    @XmlJavaTypeAdapter(CustomWeightAdapter.class)
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
}
