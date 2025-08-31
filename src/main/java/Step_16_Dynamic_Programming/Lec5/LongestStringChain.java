package Step_16_Dynamic_Programming.Lec5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

	public static int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 1;

        for (String word : words) {
            dp.put(word, 1); // min length
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(prev)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(prev) + 1));
                }
            }
            maxLen = Math.max(maxLen, dp.get(word));
        }
        return maxLen;
    }

}
