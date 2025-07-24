package Step_01_Learn_the_Basics.Lec5_Basic_Recursion;

public class _02Print1toN {

	public void print1toN(int n) {
		if(n < 0)
			return;
		print1toN(n-1);
		System.out.print(n + " ");
	}
}
