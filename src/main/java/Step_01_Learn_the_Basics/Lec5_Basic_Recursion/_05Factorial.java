package Step_01_Learn_the_Basics.Lec5_Basic_Recursion;

public class _05Factorial {

	public static void main(String[] args) {
		System.out.println(factIterative(5)); // 1 * 2 * 3 * 4 * 5 = 120
		System.out.println(fact(5)); // 1 * 2 * 3 * 4 * 5 = 120
	}

	private static int factIterative(int n) {
		int fact = 1;
		for(int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}
	
	private static int fact(int n) {
		if(n <= 0) {
			return 1;
		}
		return n * fact(n-1);
	}
}
