package Step_16_Dynamic_Programming.Lec6;

import java.util.Arrays;

/**
 * Given an array arr of n integers, where arr[i] represents price of the stock
 * on the ith day. Determine the maximum profit achievable by buying and selling
 * the stock any number of times.
 * 
 * Holding at most one share of the stock at any given time is allowed, meaning
 * buying and selling the stock can be done any number of times, but the stock
 * must be sold before buying it again. Buying and selling the stock on the same
 * day is permitted.
 * 
 * 
 * Examples: Input: arr = [9, 2, 6, 4, 7, 3]
 * 
 * Output: 7
 * 
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit =
 * 6 - 2 = 4. Then buy on day 4 (price = 4) and sell on day 5 (price = 7),
 * profit = 7 - 4 = 3. Total profit is 4 + 3 = 7.
 * 
 * Input: arr = [2, 3, 4, 5, 6]
 * 
 * Output: 4
 * 
 * Explanation: Buy on day 1 (price = 2) and sell on day 5 (price = 6), profit =
 * 6 - 2 = 4. Total profit is 4.
 * 
 */
public class _02BestTimeBuySellStock2 {

	public static void main(String[] args) {
		int[] input = { 9, 2, 6, 4, 7, 3 };
		System.out.println("Recur: " + buySellStock2(input, input.length));
		System.out.println("Memo: " + buySellStock2Memo(input, input.length));
	}

	private static int buySellStock2Memo(int[] input, int n) {
		int[][] dp = new int[n][n];
		for(int[] d: dp) {
			Arrays.fill(d, -1);
		}
		return funcMemo(0, 1, input, n, dp);
	}
	
	private static int funcMemo(int ind, int buy, int[] input, int n, int[][] dp) {
		if(ind == n) {
			return 0;
		}
		
		if(dp[ind][buy] != -1) {
			return dp[ind][buy];
		}
		
		int profit = 0;
		
		if(buy == 1) {
			profit = Math.max(
						-input[ind] + funcMemo(ind+1, 0, input, n, dp),
						0 + funcMemo(ind+1, 1, input, n, dp)
					);
		}
		else {
			profit = Math.max(
					input[ind] + funcMemo(ind+1, 1, input, n, dp),
					0 + funcMemo(ind+1, 0, input, n, dp)
				);
		}
		return dp[ind][buy] = profit;
	}

	private static int buySellStock2(int[] input, int n) {
		return func(0, 1, input, n);
	}

	private static int func(int ind, int buy, int[] input, int n) {
		if(ind == n) {
			return 0;
		}
		int profit = 0;
		
		if(buy == 1) {
			profit = Math.max(
						-input[ind] + func(ind+1, 0, input, n),
						0 + func(ind+1, 1, input, n)
					);
		}
		else {
			profit = Math.max(
					input[ind] + func(ind+1, 1, input, n),
					0 + func(ind+1, 0, input, n)
				);
		}
		return profit;
	}
}
