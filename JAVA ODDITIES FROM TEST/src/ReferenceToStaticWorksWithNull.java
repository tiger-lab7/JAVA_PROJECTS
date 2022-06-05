class A1 {
    static void print() {
        System.out.println("Hello from A1");
    }
}

public class ReferenceToStaticWorksWithNull {
    public static void main(String args[]) {
        A1 a1 = null;
        a1.print();
    }
}
