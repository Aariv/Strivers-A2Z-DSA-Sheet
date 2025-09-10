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
		int[] nums = {1, 5, 2, 1, 6};
		System.out.println("Recur: "+ houseRobber2Helper(nums, nums.length));
		System.out.println("Memoization: " + houseRobber2MemoHelper(nums, nums.length));
		System.out.println("Tab: " + houseRobber2TabulationHelper(nums, nums.length));
	}
	
	private static int houseRobber2TabulationHelper(int[] nums, int ind) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = nums[1];
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
	
	private static int houseRobber2MemoHelper(int[] nums, int ind) {
		int[] dp1 = new int[ind];
		Arrays.fill(dp1, -1);
		
		int[] dp2 = new int[ind];
		Arrays.fill(dp2, -1);
		int res1 = houseRobber2Memo(0,  ind-2, nums, dp1);
		int res2 = houseRobber2Memo(1,  ind-1, nums, dp2);
		return Math.max(res1, res2);
	}
	
	private static int houseRobber2Memo(int start, int end, int[] nums, int[] dp) {
		if(end == start) {
			return dp[end] = nums[end];
		}
		if(end < start) {
			return 0;
		}

		if(dp[end] != -1) {
			return dp[end];
		}
		
		int pick = nums[end] + houseRobber2Memo(start, end-2, nums, dp);
		int notPick = 0 + houseRobber2Memo(start, end-1, nums, dp);
		return Math.max(pick, notPick);
	}

	private static int houseRobber2Helper(int[] nums, int ind) {
		int res1 = houseRobber2(0,  ind-2, nums);
		int res2 = houseRobber2(1,  ind-1, nums);
		return Math.max(res1, res2);
	}
	
	private static int houseRobber2(int start, int end, int[] nums) {
		if(end == start) {
			return nums[end];
		}
		if(end < start) {
			return 0;
		}
		int pick = nums[end] + houseRobber2(start, end-2, nums);
		int notPick = 0 + houseRobber2(start, end-1, nums);
		return Math.max(pick, notPick);
	}
}
