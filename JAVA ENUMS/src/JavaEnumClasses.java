public class JavaEnumClasses {

    public static void main(String... args) {

        System.out.println("Возраст кота Васи " + CatsWithConstructor.Vasia.getCatAge());

        for(CatsWithConstructor cwc : CatsWithConstructor.values()) {
            System.out.println(cwc + " возраст " + cwc.getCatAge());
        }
    }


}
