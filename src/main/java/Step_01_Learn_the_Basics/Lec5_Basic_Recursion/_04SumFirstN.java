package Step_01_Learn_the_Basics.Lec5_Basic_Recursion;

public class _04SumFirstN {

	public static void main(String[] args) {
		// 1 + 2 + 3 + 4 + 5 = 15
		System.out.println(sumFirstN(5));
		System.out.println(sumFirstNIterative(5));
	}

	private static int sumFirstNIterative(int n) {
		int sum = 0;
		for(int i = 1;  i <= n; i++) {
			sum += i;
		}
		return sum;
	}

	private static int sumFirstN(int n) {
		if(n <= 0) {
			return n;
		}
		return n+ sumFirstN(n-1);
	}
}
