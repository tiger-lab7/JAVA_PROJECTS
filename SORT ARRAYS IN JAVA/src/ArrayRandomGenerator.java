public class ArrayRandomGenerator {

    //private final long ARRAY_SIZE = 4_294_967_296L;
    //private final int ARRAY_SIZE = 1_073_741_824;
    private final int ARRAY_SIZE = 286_435_456;

    public int[] intArray = new int[ARRAY_SIZE];

    public void fillArray() {

        for(int i = 0; i < ARRAY_SIZE; i++) {

            intArray[i] = (int) (java.lang.Math.random() * 1000);
        }
    }
}
