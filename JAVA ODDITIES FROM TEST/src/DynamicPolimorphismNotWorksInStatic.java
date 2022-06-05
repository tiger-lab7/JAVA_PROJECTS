class A {
    static void print() {
        System.out.println("Parent class print!");
    }
}

class B extends A {
    static void print() {
        System.out.println("Child class print!");
    }
}

public class DynamicPolimorphismNotWorksInStatic {
    public static void main(String[] args) {
        A obj = new B();
        obj.print();
    }
}
