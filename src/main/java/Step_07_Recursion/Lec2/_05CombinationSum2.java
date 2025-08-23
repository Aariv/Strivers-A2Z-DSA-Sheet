package Step_07_Recursion.Lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _05CombinationSum2 {

	public static void main(String[] args) {
//		int[] arr = {2,5,2,1,2};
		int[] arr = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		System.out.println(powerSetLoopSum(arr, target));
	}

	private static List<List<Integer>> powerSetLoopSum(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		Arrays.sort(arr);
		powerSetLoopSum(arr.length, 0, inner, result, arr, target);
		return result;
	}

	private static void powerSetLoopSum(int n, int idx, List<Integer> inner, List<List<Integer>> result, int[] arr, int target) {
//		if(target == sum) {
//			result.add(new ArrayList<Integer>(inner));
//			return;
//		}
		if(target == 0) {
			result.add(new ArrayList<Integer>(inner));
			return;
		}
	
		for(int i = idx; i < n; i++) {
			// Handle duplicates Note: make sure the array is sorted.
			if(i > idx && arr[i-1] == arr[i])
				continue;
			
			// Handle it within the loop instead of calling a new recursive function. 
			if(target < arr[i])
				break;
			// Pick
			inner.add(arr[i]);
			powerSetLoopSum(n, i+1, inner, result, arr, target - arr[i]);
			inner.remove(inner.size()-1);
		}
	}

}
