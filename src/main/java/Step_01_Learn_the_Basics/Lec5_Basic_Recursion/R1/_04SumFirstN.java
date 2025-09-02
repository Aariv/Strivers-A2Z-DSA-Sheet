package Step_01_Learn_the_Basics.Lec5_Basic_Recursion.R1;

/**
 * Given an integer N, return the sum of first N natural numbers. Try to solve
 * this using recursion.
 * 
 * Examples: Input : N = 4
 * 
 * Output : 10
 * 
 * Explanation : first four natural numbers are 1, 2, 3, 4.
 * 
 * Sum is 1 + 2 + 3 + 4 => 10.
 * 
 * Input : N = 2
 * 
 * Output : 3
 * 
 * Explanation : first two natural numbers are 1, 2.
 * 
 * Sum is 1 + 2 => 3.
 * 
 */
public class _04SumFirstN {

	public static void main(String[] args) {
		System.out.println(sum(4));
	}

	private static int sum(int n) {
		if(n == 0) {
			return 0;
		}
		return n + sum(n-1);
	}
}
