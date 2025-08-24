package Step_07_Recursion.Lec1;

public class _02Pow {

	public static void main(String[] args) {
		printN(5);
	}

	private static void printN(int n) {
//		for(int i = 1;  i <= n; i++) {
//			System.out.print((n-i)+1 + " ");
//		}
		
		for(int i = n;  i > -1; i--) {
			System.out.print(i + " ");
		}
	}
}
