package Step_16_Dynamic_Programming.Lec2;

import java.util.Arrays;

public class _01ClimbingStars {

	public static void main(String[] args) {
		fib(4);
	}

	private static void fib(int n) {
		// Recursion
		long start = System.currentTimeMillis();
		System.out.println("Using Recur: " + fibRecursion(n));
		long end = System.currentTimeMillis();
		System.out.println("Total Recur : " + (end - start));
		start = System.currentTimeMillis();
		// Memoization - Top-Down Approach
		// Initialize DP
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		// Pass the DP array
		System.out.println("Using Memoization: " + fibMemoization(n, dp));
		end = System.currentTimeMillis();
		System.out.println("Total Mem : " + (end - start));
		// Tabulation - Bottom Up approach
		start = System.currentTimeMillis();
		System.out.println("Using Tabulation: " + fibTabulation(n));
		end = System.currentTimeMillis();
		System.out.println("Total Tab : " + (end - start));
	}

	private static int fibTabulation(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1; dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}

	private static int fibMemoization(int n, int[] dp) {
		if(n == 0) {
			return dp[n] = 1;
		}
		if(n == 1) {
			return dp[n] = 1;
		}
		if(dp[n] != -1) {
			return dp[n];
		}
		return dp[n] = fibMemoization(n-1, dp) + fibMemoization(n-2, dp);
	}

	private static int fibRecursion(int n) {
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return 1;
		}
		return fibRecursion(n-1) + fibRecursion(n-2);
	}
}
