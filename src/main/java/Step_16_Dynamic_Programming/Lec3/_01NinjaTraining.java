package Step_16_Dynamic_Programming.Lec3;

import java.util.Arrays;

/**
 * A ninja has planned a n-day training schedule. Each day he has to perform one
 * of three activities - running, stealth training, or fighting practice. The
 * same activity cannot be done on two consecutive days and the ninja earns a
 * specific number of merit points, based on the activity and the given day.
 * 
 * 
 * 
 * Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and
 * matrix[i][2], represent the merit points associated with running, stealth and
 * fighting practice, on the (i+1)th day respectively. Return the maximum
 * possible merit points that the ninja can earn.
 * 
 * 
 * Examples: Input: matrix = [[10, 40, 70], [20, 50, 80], [30, 60, 90]]
 * 
 * Output: 210
 * 
 * Explanation:
 * 
 * Day 1: fighting practice = 70
 * 
 * Day 2: stealth training = 50
 * 
 * Day 3: fighting practice = 90
 * 
 * Total = 70 + 50 + 90 = 210
 * 
 * This gives the optimal points.
 * 
 * Input: matrix = [[70, 40, 10], [180, 20, 5], [200, 60, 30]]
 * 
 * Output: 290
 * 
 * Explanation:
 * 
 * Day 1: running = 70
 * 
 * Day 2: stealth training = 20
 * 
 * Day 3: running = 200
 * 
 * Total = 70 + 20 + 200 = 290
 * 
 * This gives the optimal points.
 */
public class _01NinjaTraining {

	public static void main(String[] args) {
//		int[][] matrix = {
//				{70, 40, 10}, 
//				{180, 20, 5}, 
//				{200, 60, 30}
//		};
		
		int[][] matrix = {
				{70, 40, 10}, 
				{80, 20, 50}, 
				{20, 60, 30}
		};
		System.out.println(ninjaTraining(matrix));
		System.out.println("Mem: " + ninjaTrainingMem(matrix));
		System.out.println("Tab: " + ninjaTrainingTab(matrix));
	}
	
	public static int ninjaTrainingTab(int[][] matrix) {
		int[][] dp = new int[matrix.length][4];
		dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
		dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
		dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
		int maxE = Math.max(matrix[0][0], matrix[0][1]);
		dp[0][3] = Math.max(maxE, matrix[0][2]);
		// Day
		for(int day = 1; day <= matrix.length-1; day++) {
			for(int last = 0; last <= 3; last++) {
				int max = 0;
				for(int t = 0; t <= 2; t++) {
					if(last != t) {
						int currMerit = matrix[day][t] + dp[day -1][t];
						max = Math.max(currMerit, max);
					}
				}
				dp[day][last] = max;
			}
			
		}
		return dp[matrix.length-1][3];
	}
	
	public static int ninjaTrainingMem(int[][] matrix) {
		// parameters
		int day = matrix.length-1;
		int[][] dp = new int[matrix.length][4];
		for(int i = 0; i < matrix.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return funcMem(matrix, day, 3, dp);
    }
	
	private static int funcMem(int[][] matrix, int day, int last, int[][] dp) {
		if(dp[day][last]!=-1){
			return dp[day][last];
		}
		// Base condition
		if(day == 0) {
			int max = 0;
			for(int i = 0; i <=2; i++) {
				if(last != i) {
					max = Math.max(max, matrix[day][i]);
				}
			}
			return dp[day][last] = max;
		}
		else {
			int max = 0;
			for(int i = 0; i <= 2; i++) {
				if(last != i) {
					int currMerit = matrix[day][i] + funcMem(matrix, day -1, i, dp);
					max = Math.max(currMerit, max);
				}
			}
			return dp[day][last] = max;
		}
	}
	
	public static int ninjaTraining(int[][] matrix) {
		// parameters
		int day = matrix.length-1;
		return func(matrix, day, 3);
    }

	private static int func(int[][] matrix, int day, int last) {
		// Base condtion
		if(day == 0) {
			int max = 0;
			for(int i = 0; i <=2; i++) {
				if(last != i) {
					max = Math.max(max, matrix[day][i]);
				}
			}
			return max;
		}
		else {
			int max = 0;
			for(int i = 0; i <= 2; i++) {
				if(last != i) {
					int currMerit = matrix[day][i] + func(matrix, day -1, i);
					max = Math.max(currMerit, max);
				}
				
			}
			return max;
		}
	}
}
