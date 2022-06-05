import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Iterator;

enum Colors {Red, Green, White, Black, Yellow, Blue}

public class JavaIterators {

    private static ArrayList<Car> arrayList = new ArrayList<>();
    private static ArrayListNode<Car> homeArrayList = new ArrayListNode<>();

    public static void main(String... args) {

        Car ferrari = fabricCar("Ferrari 360 Spider", Colors.Red, 450);
        Car bugatti = fabricCar("Bugatti", Colors.Blue, 1000);


        arrayList.add(ferrari);
        arrayList.add(bugatti);

        Iterator<Car> iter = arrayList.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next().getName());
        }

        homeArrayList.add(ferrari);
        homeArrayList.add(bugatti);
        System.out.println("ЭТО САМОДЕЛЬНЫЙ ARRAY LIST! " + homeArrayList.get(1).getName());
    }

    @Contract(value = "_, _, _ -> new", pure = true)//What is this?
    private static Car fabricCar(String name, Colors color, int horsepower) {
        return new Car(name, color, horsepower);
    }

}

class Car {
    private String name;
    private int horsepower;
    private Colors color;

    Car(String name, Colors color) {
        this.name = name;
        this.color = color;
    }

    Car(String name, Colors color, int horsepower) {
        this.name = name;
        this.color = color;
        this.horsepower = horsepower;
    }

    public void setHorsePower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getName() {
        return name;
    }
}
