import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LevenshteinDistanceTest {

    @Test
    void levenshteinDistanceCount0() {
        String word1 = "молоко";
        String word2 = "колокол";
        int result = LevenshteinDistance.levenshteinDistanceCount(word1, word2);
        Assertions.assertEquals(result, 2);
    }

    @Test
    void levenshteinDistanceCount1() {
        String word1 = "паровоз";
        String word2 = "синхрофазатрон";
        int result = LevenshteinDistance.levenshteinDistanceCount(word1, word2);
        Assertions.assertEquals(result, 11);
    }

}