package Step_16_Dynamic_Programming.Lec2;

import java.util.Arrays;

/**
 * Given an integer array nums of size n. Return the maximum sum possible using
 * the elements of nums such that no two elements taken are adjacent in nums.
 * 
 * Examples: Input: nums = [1, 2, 4]
 * 
 * Output: 5
 * 
 * Explanation: [1, 2, 4], the underlined elements are taken to get the maximum
 * sum.
 * 
 * Input: nums = [2, 1, 4, 9]
 * 
 * Output: 11
 * 
 * Explanation: [2, 1, 4, 9], the underlined elements are taken to get the
 * maximum sum.
 * 
 * 
 */
public class _05HouseRobber {

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
