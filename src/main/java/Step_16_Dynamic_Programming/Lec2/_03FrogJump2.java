package Step_16_Dynamic_Programming.Lec2;

import java.util.Arrays;

/**
 * A frog wants to climb a staircase with n steps. Given an integer array
 * heights, where heights[i] contains the height of the ith step, and an integer
 * k.
 * 
 * To jump from the ith step to the jth step, the frog requires abs(heights[i] -
 * heights[j]) energy, where abs() denotes the absolute difference. The frog can
 * jump from the ith step to any step in the range [i + 1, i + k], provided it
 * exists. Return the minimum amount of energy required by the frog to go from
 * the 0th step to the (n-1)th step.
 * 
 * Examples: Input: heights = [10, 5, 20, 0, 15], k = 2
 * 
 * Output: 15
 * 
 * Explanation:
 * 
 * 0th step -> 2nd step, cost = abs(10 - 20) = 10
 * 
 * 2nd step -> 4th step, cost = abs(20 - 15) = 5
 * 
 * Total cost = 10 + 5 = 15.
 * 
 * Input: heights = [15, 4, 1, 14, 15], k = 3
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * 0th step -> 3rd step, cost = abs(15 - 14) = 1
 * 
 * 3rd step -> 4th step, cost = abs(14 - 15) = 1
 * 
 * Total cost = 1 + 1 = 2.
 * 
 */
public class _03FrogJump2 {
	
	public static void main(String[] args) {
		int[] heights = {10, 5, 20, 0, 15};
		int k = 2;
		System.out.println(frogJumpRecursion(heights, k));
		System.out.println("Memo: " + frogJumpMemoization(heights, k));
		System.out.println("Tab: " + frogJumpTabulation(heights, k));
	}

	private static int frogJumpTabulation(int[] heights, int k) {
		
		int n = heights.length;
		int[] dp = new int[n];
		dp[0] = 0;
		
		for(int j = 1; j < n; j++) {
			int min = Integer.MAX_VALUE;
			for(int i = 1; i <= k; i++) {
				if(j >= i) {
					int jump = Math.abs(heights[j] - heights[j-i]) + dp[j-i];
					min = Math.min(jump, min);
				}
			}
			dp[j] = min;
		}
		return dp[n-1];
	}

	private static int frogJumpMemoization(int[] heights, int k) {
		int n = heights.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return frogJumpMemoization(heights, n-1, k, dp);
	}

	private static int frogJumpMemoization(int[] heights, int n, int k, int[] dp) {
		if(n == 0) {
			return dp[n] = 0;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= k; i++) {
			if(n >= i) {
				int jump = Math.abs(heights[n] - heights[n-i])
						+ frogJumpMemoization(heights, n-i, k, dp);
				
				min = Math.min(jump, min);
			}
		}
		return dp[n] = min;
	}

	private static int frogJumpRecursion(int[] heights, int k) {
		return frogJumpRecursion(heights, heights.length-1, k);
	}

	private static int frogJumpRecursion(int[] heights, int n, int k) {
		if(n == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= k; i++) {
			if(n >= i) {
				int jump = Math.abs(heights[n] - heights[n-i])
						+ frogJumpRecursion(heights, n-i, k);
				
				min = Math.min(jump, min);
			}
		}
		return min;
	}
}
