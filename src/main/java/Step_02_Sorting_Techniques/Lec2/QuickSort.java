package Step_02_Sorting_Techniques.Lec2;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {1, 4, 5, 3, 2};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr) {
		quickSort(0, arr.length-1, arr);
	}

	private static void quickSort(int start, int end, int[] arr) {
		if(start < end) {
			int pivot = partition(start, end, arr);
			quickSort(start, pivot -1, arr);
			quickSort(pivot+1, end, arr);
		}
	}

	private static int partition(int start, int end, int[] arr) {
		int i = start -1;
		int j = start, pivot = end;
		while(j < end) {
			if(arr[j] < arr[pivot]) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			j++;
		}
		// Swap with the pivot
		int temp = arr[pivot];
		arr[pivot] = arr[i+1];
		arr[i+1] = temp;
		return i+1;
	}
}
