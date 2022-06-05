public class Main {

    public static void main(String... args) {
        Tree<Long> myTree = new Tree<>();

        for(int i = 0; i < 100; i++) {
            long n = Math.round(Math.random() * 100);
            myTree.add(n);
        }
        myTree.getAll().stream().allMatch(n -> {System.out.println(n); return true;});

    }

}


