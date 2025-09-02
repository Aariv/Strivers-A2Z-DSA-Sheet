package Step_01_Learn_the_Basics.Lec5_Basic_Recursion.R1;

public class _01PrintSth {

	public static void main(String[] args) {
		print(3);
	}

	private static void print(int n) {
		if(n == 0) {
			return;
		}
		System.out.println("Sth");
		print(n-1);
		System.out.println("AftSth");
	}
	
	private static void print2(int n) {
		if(n == 0) {
			return;
		}
		System.out.println("Sth");
		print(n-1);
	}
}
