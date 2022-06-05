public class Test_HomeMadeArrayList {
    public static void main(String ... args) {

        ArrayListNode<Double> homeMadeArrayList = new ArrayListNode<>();

        for(double i = 0; i < 1_000_001; i++) {
            homeMadeArrayList.add(i);
        }

        int i = 0;
        while(homeMadeArrayList.get(i) != null) {
            if (homeMadeArrayList.get(i) % 1000 == 0)
                    System.out.println(homeMadeArrayList.get(i));
                    i++;
        }
    }
}
