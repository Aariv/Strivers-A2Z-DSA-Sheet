package Step_02_Sorting_Techniques.Lec1;

public class _02BubbleSort {
	
	public static void main(String[] args) {
		int[] nums = {5, 1, 4, 2, 8};
        int[] sorted = bubbleSort(nums);

        for (int num : sorted) {
            System.out.print(num + " ");
        }
	}

	public static int[] bubbleSort(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			// Flag to detect any swap
			boolean swapped = false;

			// Last i elements are already sorted
			for (int j = 0; j < n - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					// Swap nums[j] and nums[j + 1]
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					swapped = true;
				}
			}

			// If no two elements were swapped in inner loop, array is sorted
			if (!swapped)
				break;
		}
		return nums;
	}
}
