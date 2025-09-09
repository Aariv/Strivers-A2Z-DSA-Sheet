package Step_16_Dynamic_Programming.Lec6;

/**
 * Best time to buy and sell stock
 * 
 * Given an array arr of n integers, where arr[i] represents price of the stock
 * on the ith day. Determine the maximum profit achievable by buying and selling
 * the stock at most once.
 * 
 * The stock should be purchased before selling it, and both actions cannot
 * occur on the same day.
 *
 * Examples: Input: arr = [10, 7, 5, 8, 11, 9]
 * 
 * Output: 6
 * 
 * Explanation: Buy on day 3 (price = 5) and sell on day 5 (price = 11), profit
 * = 11 - 5 = 6.
 * 
 * Input: arr = [5, 4, 3, 2, 1]
 * 
 * Output: 0
 * 
 * Explanation: In this case, no transactions are made. Therefore, the maximum
 * profit remains 0.
 * 
 */
public class _01BestTimeBuySellStock {

	public static void main(String[] args) {
		int[] input = {10, 7, 5, 8, 11, 9};
		buySellStock(input);
	}

	private static int buySellStock(int[] input) {
		int mini = input[0], profit = 0;
		
		for(int i = 1; i < input.length; i++) {
			int cost = input[i] - mini;
			profit = Math.max(profit, cost);
			mini = Math.min(mini, input[i]);
		}
		
		return profit;
	}
}
