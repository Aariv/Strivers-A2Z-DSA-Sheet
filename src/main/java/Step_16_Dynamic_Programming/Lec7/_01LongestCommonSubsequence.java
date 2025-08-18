package Step_16_Dynamic_Programming.Lec7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _01LongestCommonSubsequence {

	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums)); // Output: 4
	}
	
	public static int lengthOfLIS(int[] nums) {
		
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        // Base case: every element is an LIS of length 1
        for (int i = 0; i < n; i++) dp[i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
	
	public static int lengthOfLISOptimized(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        
        for (int num : nums) {
            int idx = Collections.binarySearch(temp, num);
            if (idx < 0) idx = -idx - 1;  // lower_bound
            if (idx == temp.size()) {
                temp.add(num);
            } else {
                temp.set(idx, num);
            }
        }
        return temp.size();
    }
}
