public class InnerStaticClasses {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.sayHello();

        Outer2.Inner inner2 = new Outer2.Inner();
        inner2.n = 777;
        inner2.sayHello();
        Outer2.Inner inner3 = new Outer2.Inner();
        inner3.sayHello();
    }
}

class Outer {
    class Inner {
        void sayHello() {
            System.out.println("Hello from Inner class!");
        }
    }
}

class Outer2 {
    static class Inner {
        int n = 100;
        void sayHello() {
            System.out.println("Hello from Inner class! " + n);
        }
    }
}
