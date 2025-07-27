package Step_02_Sorting_Techniques.Lec1;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] nums = {5, 2, 8, 1, 3};
		
		selectionSort2(nums);
		
		System.out.println(Arrays.toString(nums));
	}

	private static void selectionSort(int[] nums) {
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			System.out.println("Count:- " + count++);
			int minIdx = i;
			// find the min
			for(int j = i; j < nums.length; j++) {
				if(nums[j] < nums[minIdx]) {
					minIdx = j;
				}
			}
			// Swap
			int temp = nums[i];
			nums[i] = nums[minIdx];
			nums[minIdx] = temp;
		}
	}
	
	private static void selectionSort2(int[] nums) {
		int n = nums.length;
		int count = 0;
		// After n - 1 passes, the last element will already be in place because all other n - 1 smaller elements have been placed before it.
		for(int i = 0; i < n-1; i++) {
			System.out.println("Count:- " + count++);
			int minIdx = i;
			// find the min
			for(int j = i+1; j < n; j++) {
				if(nums[j] < nums[minIdx]) {
					minIdx = j;
				}
			}
			// Swap
			if(minIdx != i) {
				int temp = nums[i];
				nums[i] = nums[minIdx];
				nums[minIdx] = temp;
			}
		}
	}
}
