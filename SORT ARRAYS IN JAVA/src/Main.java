public class Main {

    public static void main(String[] args) {
    new Test();


    }
}

class Test {

    Test() {
        ArrayRandomGenerator array1 = new ArrayRandomGenerator() {{
            fillArray();
        }};

        //Sort1 sort1 = new Sort1(array1.intArray);

        //array1.intArray = sort1.sortByStream();
        //array1.intArray = sort1.sortBubble();
        //array1.intArray = sort1.mergeSort(array1.intArray);

        int[] resultArray = Sort1.mergeSort(array1.intArray);
        for(int i : resultArray) {System.out.println(i);}

        new ArrayReader() {
            {
            //readArray(array1.intArray);
            }
        };
    }
}

