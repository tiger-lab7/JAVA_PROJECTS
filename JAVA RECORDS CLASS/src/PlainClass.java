import java.util.Objects;

public class PlainClass {
    private int number;
    private String name;

    PlainClass(int number,String name) {
        this.number = number;
        this.name = name;
    }

    public int number() {return number;}

    public String name() {return name;}

    public int hashCode() {
        return Objects.hash(number, name);
    }
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof PlainClass)) return false;
        PlainClass testObject = (PlainClass) o;
        return testObject.number == this.number && testObject.name == this.name;
    }
    public String toString() {
        return String.format("Номер кота %d, имя кота %s", number, name);
    }

}
