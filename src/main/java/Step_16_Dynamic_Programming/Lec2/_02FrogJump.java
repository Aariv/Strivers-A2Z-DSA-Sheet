package Step_16_Dynamic_Programming.Lec2;

import java.util.Arrays;

/**
 * A frog wants to climb a staircase with n steps. Given an integer array
 * heights, where heights[i] contains the height of the ith step.
 * 
 * To jump from the ith step to the jth step, the frog requires abs(heights[i] -
 * heights[j]) energy, where abs() denotes the absolute difference. The frog can
 * jump from any step either one or two steps, provided it exists. Return the
 * minimum amount of energy required by the frog to go from the 0th step to the
 * (n-1)th step.
 * 
 * 
 * Examples: Input: heights = [2, 1, 3, 5, 4]
 * 
 * Output: 2
 * 
 * Explanation: One possible route can be,
 * 
 * 0th step -> 2nd Step = abs(2 - 3) = 1
 * 
 * 2nd step -> 4th step = abs(3 - 4) = 1
 * 
 * Total = 1 + 1 = 2.
 * 
 * Input: heights = [7, 5, 1, 2, 6]
 * 
 * Output: 9
 * 
 * Explanation: One possible route can be,
 * 
 * 0th step -> 1st Step = abs(7 - 5) = 2
 * 
 * 1st step -> 3rd step = abs(5 - 2) = 3
 * 
 * 3rd step -> 4th step = abs(2 - 6) = 4
 * 
 * Total = 2 + 3 + 4 = 9.
 */
public class _02FrogJump {
	
	public static void main(String[] args) {
		int[] heights = {2, 1, 3, 5, 4};
		System.out.println(frogJumpRecursion(heights));
		System.out.println("Memo: " + frogJumpMemoization(heights));
		System.out.println("Tab: " + frogJumpTabulation(heights));
	}

	private static int frogJumpTabulation(int[] heights) {
		int n = heights.length;
		int[] dp = new int[n];
		dp[0] = 0;
		for(int i = 1; i < n; i++) {
			int j1 = Math.abs(heights[i] - heights[i-1]) + dp[i-1];
			int j2 = Integer.MAX_VALUE;
			if(i > 1)
				j2 = Math.abs(heights[i] - heights[i-2]) + dp[i-2];
			dp[i] = Math.min(j1, j2);
		}
		return dp[n-1];
	}

	private static int frogJumpMemoization(int[] heights) {
		int n = heights.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return frogJumpMemoization(heights, n-1, dp);
	}

	private static int frogJumpMemoization(int[] heights, int n, int[] dp) {
		if(n == 0) {
			return dp[n] = 0;
		}
		int j1 = Math.abs(heights[n] - heights[n-1]) + frogJumpMemoization(heights, n-1, dp);
		int j2 = Integer.MAX_VALUE;
		if(n > 1)
			j2 = Math.abs(heights[n] - heights[n-2]) + frogJumpMemoization(heights, n-2, dp);
		return dp[n] = Math.min(j1, j2);
	}

	private static int frogJumpRecursion(int[] heights) {
		return frogJumpRecursion(heights, heights.length-1);
	}

	private static int frogJumpRecursion(int[] heights, int n) {
		if(n == 0) {
			return 0;
		}
		int j1 = Math.abs(heights[n] - heights[n-1]) + frogJumpRecursion(heights, n-1);
		int j2 = Integer.MAX_VALUE;
		if(n > 1)
			j2 = Math.abs(heights[n] - heights[n-2]) + frogJumpRecursion(heights, n-2);
		return Math.min(j1, j2);
	}
}
