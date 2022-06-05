import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeMapHMTest {
    private  TreeMapHM<Integer, String> treeMapHM;

    @BeforeEach
    void generateMap() {
        treeMapHM = new TreeMapHM<>();

        for(int i = 0; i < 100; i++) {
            treeMapHM.put((int) (Math.random() * 1000), "CAT");
        }
    }

    @Test
    void test1() {

    }

    @AfterEach
    void printMapEntry() {
        treeMapHM.entrySet().forEach(entry ->
                System.out.println(entry.getKey() + " " + entry.getValue()));
    }

}