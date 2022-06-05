package hanoi_towers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HanoiTowers {
    static final int TOWER_SIZE = 15;

    static Deque<Integer> tower1 = new ArrayDeque<>(TOWER_SIZE);
    static Deque<Integer> tower2 = new ArrayDeque<>(TOWER_SIZE);
    static Deque<Integer> tower3 = new ArrayDeque<>(TOWER_SIZE);
    static List<Deque<Integer>> towers = new ArrayList<>(3);
    static int moveCount = 0;

    private static void moveDisk(int fromDequeIndex, int toDequeIndex) {
        int disk = towers.get(fromDequeIndex).pollFirst();
        System.out.println("#" + ++moveCount + " Move disk " + disk + " from " + (fromDequeIndex + 1)
                + " to " + (toDequeIndex + 1));
        towers.get(toDequeIndex).addFirst(disk);
    }


    static void hanoiTowers(int numberOfDisks, int fromTowerIndex, int toTowerIndex) {

        printTowers();

        if (numberOfDisks == 0) return;

        int tmpTowerIndex = 3 - fromTowerIndex - toTowerIndex;
        hanoiTowers(numberOfDisks - 1, fromTowerIndex, tmpTowerIndex);
        moveDisk(fromTowerIndex, toTowerIndex);
        hanoiTowers(numberOfDisks - 1, tmpTowerIndex, toTowerIndex);

    }

    static void printTowers() {
        for (int i = 0; i < towers.size(); ++i) {
            System.out.println("Tower " + (i + 1));
            towers.get(i).forEach(n -> System.out.print(n + " "));
            System.out.println("\n--------------------------------------------");
        }
    }


    public static void main(String... args) {
        tower1.addAll(IntStream.iterate(1, i -> ++i)
                .limit(TOWER_SIZE).boxed().collect(Collectors.toList()));
        towers.add(tower1);
        towers.add(tower2);
        towers.add(tower3);

        hanoiTowers(tower1.size(), 0, 1);
        printTowers();
    }
}
