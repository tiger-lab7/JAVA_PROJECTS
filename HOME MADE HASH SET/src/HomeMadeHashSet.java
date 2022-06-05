public class HomeMadeHashSet {

    public static void main(String... args) throws Exception {

        HashSetHM<Integer> myHashSet = new HashSetHM<>();
        for(int i = 0; i < 100; i++) {
            myHashSet.add((int) (Math.random() * 10));
        }

        for(int i = 0; i < 100; i++) {
            System.out.println(i + " " + myHashSet.get() );
        }

       /* myHashSet.add(100);
        myHashSet.add(100);
        myHashSet.add(100);
        System.out.println(myHashSet.get());
        System.out.println(myHashSet.get());
        System.out.println(myHashSet.get());*/


    }
}
