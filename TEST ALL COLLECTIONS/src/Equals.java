public class Equals {

    public static void main(String[] args) {
       /* System.out.println(new Simpson("Homer", 35, 120)
                .equals(new Simpson("Homer", 35, 120)));

        System.out.println(new Simpson("Homer", 35, 120)
                == new Simpson("Homer", 35, 120));

        System.out.println(new Simpson("Bart", 10, 120)
                .equals(new Simpson("El Barto", 10, 45)));
    */

    Simpson homer1 = new Simpson("Homer", 35, 120);
    Simpson homer2 = new Simpson("Homer", 35, 120);
    Simpson homer3 = homer1;
    System.out.println(homer1.equals(homer2));
    System.out.println(homer1 == homer2);
    System.out.println(homer3.equals(homer1));
    System.out.println(homer3 == homer1);


}

}

class Simpson{
        private String name;
        private int age;
        private int weight;

        public Simpson(String name,int age,int weight){
            this.name = name;
            this.age= age;
            this.weight=weight;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) {       // Просто this - это ссылка на сам объект класса
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Simpson simpson=(Simpson) o;
        return age == simpson.age &&
                weight == simpson.weight &&
                name.equals(simpson.name);
    }

}
