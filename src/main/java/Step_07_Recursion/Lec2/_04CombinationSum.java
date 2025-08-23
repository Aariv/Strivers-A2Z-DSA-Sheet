package Step_07_Recursion.Lec2;

import java.util.ArrayList;
import java.util.List;

public class _04CombinationSum {

	public static void main(String[] args) {
//		int[] arr = {1, 2, 2};
//		int[] arr = {2,3,6,7};
		int[] arr = {2,3,5};
		int target = 8;
		System.out.println(powerSetLoopSum(arr, target));
	}

	private static List<List<Integer>> powerSetLoopSum(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
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
		if(target < 0) {
			return;
		}
		for(int i = idx; i < n; i++) {
			// Handle duplicates
//			if(i > idx && arr[i-1] == arr[i])
//				continue;
			// Pick
			inner.add(arr[i]);
			powerSetLoopSum(n, i, inner, result, arr, target - arr[i]);
			inner.remove(inner.size()-1);
		}
	}

}
