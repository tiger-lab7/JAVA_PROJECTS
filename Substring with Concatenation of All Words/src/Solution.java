/*
Time complexity: O(M * N * wordLength)
Space: O( N + M)

where N is the number of characters in string s and M is the number of words

The algorithm is as follows:

Keep the frequency of every word in a HashMap.
Starting from every index in the string, try to match all the words.
In each iteration, keep track of all the words that we have already seen in another HashMap.
If a word is not found or has a higher frequency than required, we can move on to the next character in the string.
Store the index if we have found all the words.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> resultIndices = new ArrayList<>();

        Map<String, Integer> wordFreqMap = new HashMap<>();
        for (String word: words) {
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
        }

        int wordsCount = words.length;
        int wordLength = words[0].length();

        for (int i = 0; i <= s.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();

            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                String word = s.substring(nextWordIndex, nextWordIndex + wordLength);

                if (!wordFreqMap.containsKey(word)) break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                if (wordsSeen.get(word) > wordFreqMap.get(word)) break;

                if (j + 1 == wordsCount) {
                    resultIndices.add(i);
                }
            }
        }

        return resultIndices;

    }
}
