package Step_01_Learn_the_Basics.Lec5_Basic_Recursion.R1;

/**
 * Given an array arr of n elements. The task is to reverse the given array. The
 * reversal of array should be inplace.
 * 
 * Examples: Input: n=5, arr = [1,2,3,4,5]
 * 
 * Output: [5,4,3,2,1]
 * 
 * Explanation: The reverse of the array [1,2,3,4,5] is [5,4,3,2,1]
 */
public class _06ReverseArray {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5 };
		int n = input.length;
		int start = 0, end = n - 1;
		reverse(input, start, end);
	}

	private static void reverse(int[] input, int start, int end) {
		if (start < end) {
			int temp = input[start];
			input[start] = input[end];
			input[end] = temp;

			reverse(input, start + 1, end - 1);
		}

	}
}
