package Step_16_Dynamic_Programming.Lec7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _03LargestDivisibleSubset {
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 4, 8};
        System.out.println(largestDivisibleSubset(nums)); // [1, 2, 4, 8]
	}

	public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1, maxIdx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        // reconstruct subset
        List<Integer> result = new ArrayList<>();
        while (maxIdx != -1) {
            result.add(nums[maxIdx]);
            maxIdx = parent[maxIdx];
        }
        Collections.reverse(result);
        return result;
    }
}
