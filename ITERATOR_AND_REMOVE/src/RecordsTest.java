public class RecordsTest {

    record Season(int id, String name){
        //@Override
       /* public String toString() {
            return "Season{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }*/
    };

    public static void main(String[] args) {

        Season winter = new Season(1, "Winter");
        Season spring = new Season(2, "Spring");
        Season summer = new Season(3, "Summer");
        Season autumn = new Season(4, "Autumn");

        System.out.println(winter.toString());
        System.out.println(winter.equals(summer));
        System.out.println(spring.hashCode());
    }

}


