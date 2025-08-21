package Step_01_Learn_the_Basics.Lec5_Basic_Recursion;

public class _01PrintSomething {

	public static void main(String[] args) {
		printSomething01("Ariv", 5);
	}

	private static void printSomething(String name, int i) {
		if(i > 0) {
			System.out.println(name);
			i--;
			printSomething(name, i);
		}
	}
	
	private static void printSomething01(String name, int i) {
		if(i <= 0) {
			return;
		}
		System.out.println(name);
		printSomething01(name, i-1);
	}
}
