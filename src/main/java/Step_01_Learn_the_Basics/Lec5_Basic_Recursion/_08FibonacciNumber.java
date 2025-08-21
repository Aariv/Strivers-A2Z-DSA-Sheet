package Step_01_Learn_the_Basics.Lec5_Basic_Recursion;

public class _08FibonacciNumber {

	public static void main(String[] args) {
		System.out.println(fibonacci(5)); // 0, 1, 1, 2, 3
		System.out.println(fibonacciIterative(5));
	}

	private static int fibonacciIterative(int n) {
		int a = 0;
		int b = 1;
		
		for(int i = 1; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	private static int fibonacci(int n) {
		if(n <= 1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
