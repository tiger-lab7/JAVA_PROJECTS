public class Main {

    public static void main(String... args) throws Exception {

        HashMapHM<Integer, Double> hashMapHM = new HashMapHM(10, 0.75F);

        for(int i = 0; i < 100; i++ ) {
            hashMapHM.put(i, (Math.random() * 1000));
        }

        for(int i = 0; i < 100; i++ ) {
            hashMapHM.put(i, (Math.random() * 1000));
        }

        for(int i = 0; i < 100; i++ ) {
            System.out.println(hashMapHM.get(i));
        }



    }
}
