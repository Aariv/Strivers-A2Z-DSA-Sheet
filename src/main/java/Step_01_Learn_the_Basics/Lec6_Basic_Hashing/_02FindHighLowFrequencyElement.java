package Step_01_Learn_the_Basics.Lec6_Basic_Hashing;

import java.util.HashMap;
import java.util.Map;

public class _02FindHighLowFrequencyElement {
	
	public static void main(String[] args) {
		int[] arr = {10, 5, 10, 15, 10, 5};
        findHighLowFrequency(arr);
	}

	public static void findHighLowFrequency(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Track min and max frequency values
        int minFreq = Integer.MAX_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        int minElement = -1;
        int maxElement = -1;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                maxElement = key;
            }

            if (freq < minFreq) {
                minFreq = freq;
                minElement = key;
            }
        }

        System.out.println(maxElement + " " + minElement);
    }
}
