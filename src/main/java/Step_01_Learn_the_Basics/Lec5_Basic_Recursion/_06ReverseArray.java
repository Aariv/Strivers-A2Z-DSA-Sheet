package Step_01_Learn_the_Basics.Lec5_Basic_Recursion;

import java.util.Arrays;

public class _06ReverseArray {

	public static void main(String[] args) {
		int[] arr = {1, 23, 5, 6, 6};
		
		reverse(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
//		reverseIterative(arr);
		
//		System.out.println(Arrays.toString(arr));
	}

	private static void reverseIterative(int[] arr) {
		for(int i = 0, j = arr.length-1; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	private static void reverse(int[] arr, int i, int j) {
		if( i > j) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		reverse(arr, i+1, j-1);
	}
}
