public class Main {
    static TestClass[] testClassArray = new TestClass[20];

    public static void main(String[] args) {


        for (int i = 0; i < 20; i++) {

            testClassArray[i] = new TestClass(i);
        }
        System.out.println(testClassArray.getClass().getAnnotations());


        for (TestClass tc : testClassArray) {

        }
    }


}


class TestClass {

    @Annotation1(id = 10)
    public int i;

    public TestClass(int i) {
        this.i = i;
    }
}
