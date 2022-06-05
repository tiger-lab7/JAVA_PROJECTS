public class VirtualMethod {

    public static void main(String... args) {

        Animal zoo[] = {new Wolf(), new Animal(), new Cat(), new catVasia()};

        for (Animal a : zoo) {   // тип_переменной  имя_переменной-итератора : контейнер
            a.eat();
            a.voice();
        }
    }

}

class Animal {
    public void eat() {
        System.out.println("КУШАЮ!");
    }

    public void voice() {
        System.out.println("ПОДАЮ ГОЛОС!");
    }

    ;
}

class Wolf extends Animal {

    public void eat() {
        System.out.println("КУШАЮ МЯСО!");
    }

    public void voice() {
        System.out.println("ГАВ_ГАВ!");
        super.voice();
    }
}

class Cat extends Animal {

    public void eat() {
        System.out.println("КУШАЮ КОШАЧИЙ КОРМ!");
    }

    public void voice() {
        System.out.println("МЯУ-МЯУ!");
    }
}

class catVasia extends Cat {

    public void eat() {
        System.out.println("КУШАЮ ВИСКАС!");
        super.eat();
    }

}


