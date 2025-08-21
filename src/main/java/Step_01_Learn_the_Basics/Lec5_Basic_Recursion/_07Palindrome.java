package Step_01_Learn_the_Basics.Lec5_Basic_Recursion;

public class _07Palindrome {

	public static void main(String[] args) {
		String str = "madam";
//		System.out.println(palindromeIterative(str));
		System.out.println(palindrome(str, 0, str.length()-1));
	}

	private static boolean palindromeIterative(String str) {
		for(int i = 0, j = str.length()-1; i < j; i++, j--) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	private static boolean palindrome(String str, int i, int j) {
		if( i > j) {
			return true;
		}
		if(str.charAt(i) != str.charAt(j)) {
			return false;
		}
		
		return palindrome(str, i+1, j-1);
	}
}
