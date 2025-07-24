package Step_01_Learn_the_Basics.Lec5_Basic_Recursion;

public class _03PrintNto1 {

	public void print(int n) {
        if (n < 0) 
        	return;
        System.out.println(n);  // Print before recursive call
        print(n - 1);
    }

}
