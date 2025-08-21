package Step_01_Learn_the_Basics.Lec5_Basic_Recursion;

public class _03PrintNto1 {
	
	public static void main(String[] args) {
		print(5);
	}

	public static void print(int n) {
        if (n <= 0) {
        	return;
        }
        System.out.print(n + " ");  // Print before recursive call
        print(n - 1);
    }

}
