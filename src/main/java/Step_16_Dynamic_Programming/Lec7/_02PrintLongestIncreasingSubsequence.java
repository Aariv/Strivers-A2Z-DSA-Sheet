package Step_16_Dynamic_Programming.Lec7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _02PrintLongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(getLIS(nums)); // [2, 3, 7, 101]
	}

	public static List<Integer> getLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n]; // stores previous index
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1, lastIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j; // link back
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct LIS
        List<Integer> lis = new ArrayList<>();
        while (lastIndex != -1) {
            lis.add(nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }
        Collections.reverse(lis);
        return lis;
    }
}
