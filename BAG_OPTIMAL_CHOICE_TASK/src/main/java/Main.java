public class Main {

    public static void main(String[] args) {
        Treasure[] treasures = { // #1 + #3 + #4 = $16
                new Treasure(3, 5),
                new Treasure(4, 5),
                new Treasure(5, 7),
                new Treasure(2, 4),
                new Treasure(7, 9)
        };
        int MAX_WEIGHT = 10;
        int result = KnapsackOptimal.findMaxCost(treasures, MAX_WEIGHT);
        System.out.println(result);
    }
}
