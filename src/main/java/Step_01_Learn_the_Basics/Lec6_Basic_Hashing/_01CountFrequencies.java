package Step_01_Learn_the_Basics.Lec6_Basic_Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given an array nums of size n which may contain duplicate elements, 
// return a list of pairs where each pair contains a unique element from the array and its frequency in the array.

public class _01CountFrequencies {

//	Input: nums = [1, 2, 2, 1, 3]
//
//	Output: [[1, 2], [2, 2], [3, 1]]
//
//			Explanation:
//
//			- 1 appears 2 times
//
//			- 2 appears 2 times
//
//			- 3 appears 1 time
//
//			Order of output can vary.
	public List<List<Integer>> countFrequencies(int[] nums) {
		// Step 1: Count frequencies using a map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Prepare the result list
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());      // element
            pair.add(entry.getValue());    // frequency
            result.add(pair);
        }
        return result;
	}
}
