package Step_02_Sorting_Techniques.Lec2;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {1, 4, 5, 3, 2};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr) {
		mergeSort(0, arr.length-1, arr);
	}

	private static void mergeSort(int start, int end, int[] arr) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid, arr);
			mergeSort(mid+1, end, arr);
			merge(start, mid, end, arr);
		}
	}

	private static void merge(int start, int mid, int end, int[] arr) {
		int n1 = mid - start + 1;
		int n2 = end - mid;
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(int i = start, j = 0; j < n1; i++, j++) {
			left[j] = arr[i];
		}
		
		for(int i = mid+1, j = 0; j < n2; i++, j++) {
			right[j] = arr[i];
		}
		
		int i = 0, j = 0, k = start;
		
		while(i < n1 && j < n2) {
			if(left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i < n1) {
			arr[k] = left[i];
			k++;
			i++;
		}
		
		while(j < n2) {
			arr[k] = right[j];
			k++;
			j++;
		}
 	}
}
