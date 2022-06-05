public class Main {

    public static void main(String[] args) {
        Test test = Test.builder().setSurname("Котофеич").setName("Кот").setColor("Brown").build();
        System.out.println(test.name + " " + test.surname + " " + test.color);

        Test test1 = Test.builder().setColor("Orange").setSurname("Пушок").setName("Снежный").build();
        System.out.println(test1.name + " " + test1.surname + " " + test1.color);
    }

}

class Test {
    // Вложенный класс - билдер
    public static class Builder {
        private String name;
        private String surname;
        private String color;

        // Эта фабрика вложенного класса - основной метод класса, возвращающий его экземпляр
        public Test build() {
            return new Test(this);
        }
        // Методы билдера для конструирования параметров объекта - аналог kwargs
        // Каждый метод возвращает объект билдера для возможности вызова у него новых методов!
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder setColor(String color) {
            this.color = color;
            return this;
        }
    }

    public final String name;
    public final String surname;
    public final String color;
    // Конструктор класса сделан приватным и вызывается методом build с аргументами - набором параметров билдера
    private Test(Builder builder) {
        name = builder.name;
        surname = builder.surname;
        color = builder.color;
    }
    // Статический и публичный метод, возвращающий экземпляр билдера для построения класса
    public static Builder builder() {
        return new Builder();
    }
}
