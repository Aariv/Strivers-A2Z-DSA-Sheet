package Step_16_Dynamic_Programming.Lec2;

import java.util.Arrays;

/**
 * A robber is targeting to rob houses from a street. Each house has security
 * measures that alert the police when two adjacent houses are robbed. The
 * houses are arranged in a circular manner, thus the first and last houses are
 * adjacent to each other. Given an integer array money, where money[i]
 * represents the amount of money that can be looted from the (i+1)th house.
 * Return the maximum amount of money that the robber can loot without alerting
 * the police.
 * 
 * Examples: Input: money = [2, 1, 4, 9]
 * 
 * Output: 10
 * 
 * Explanation: [2, 1, 4, 9] The underlined houses would give the maximum loot.
 * 
 * Note that we cannot loot the 1st and 4th houses together.
 * 
 * Input: money = [1, 5, 2, 1, 6]
 * 
 * Output: 11
 * 
 * Explanation: [1, 5, 2, 1, 6] The underlined houses would give the maximum
 * loot.
 */
public class _05HouseRobber2 {

	public static void main(String[] args) {
		int[] nums = {2, 1, 4, 9};
		System.out.println("Recur: "+ sum(nums, nums.length-1));
		System.out.println("Memoization: " + maxSumNonAdjacentMemoization(nums));
		System.out.println("Tab: " + maxSumNonAdjacentTabulation(nums));
	}
	
	/**
	 * 
	 * @param nums
	 * @return
	 */
	private static int maxSumNonAdjacentTabulation(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		for(int i = 1; i < n; i++) {
			int pick = Integer.MIN_VALUE;
			if(i>=2) {
				pick = nums[i] + dp[i-2];
			}
			int notPick = 0 + dp[i-1];
			dp[i] = Math.max(pick, notPick);
		}
		return dp[n-1];
	}

	private static int maxSumNonAdjacentMemoization(int[] nums) {
		int ind = nums.length;
		int[] dp = new int[ind];
		Arrays.fill(dp, -1);
		
		return sum(nums, ind-1, dp);
	}

	private static int sum(int[] nums, int ind, int[] dp) {
		if(ind == 0) {
			return dp[ind] = nums[0];
		}
		if(ind < 0) {
			return 0;
		}
		if(dp[ind] != -1) {
			return dp[ind];
		}
		int pick = nums[ind] + sum(nums, ind-2, dp);
		int notPick = 0 + sum(nums, ind-1, dp);
		
		return Math.max(pick, notPick);
	}
	
	private static int sum(int[] nums, int ind) {
		if(ind == 0) {
			return nums[0];
		}
		if(ind < 0) {
			return 0;
		}
		int pick = nums[ind] + sum(nums, ind-2);
		int notPick = 0 + sum(nums, ind-1);
		
		return Math.max(pick, notPick);
	}
}
