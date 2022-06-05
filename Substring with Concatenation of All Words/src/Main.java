public class Main {

    public static void main(String[] args) {

        Solution solution = new Solution();


        String s =  "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        solution.findSubstring(s, words).forEach(System.out::println);
    }
}
