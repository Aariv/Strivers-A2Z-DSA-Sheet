package Step_07_Recursion.Lec2.Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given collection of candidate numbers (candidates) and a integer target.Find
 * all unique combinations in candidates where the sum is equal to the
 * target.There can only be one usage of each number in the candidates
 * combination and return the answer in sorted order.
 * 
 * e.g : The combination [1, 1, 2] and [1, 2, 1] are not unique.
 * 
 * 
 * Examples: Input : candidates = [2, 1, 2, 7, 6, 1, 5] , target = 8
 * 
 * Output : [ [1, 1, 6] , [1, 2, 5] , [1, 7] , [2, 6] ]
 * 
 * Explanation : The combinations sum up to target are
 * 
 * 1 + 1 + 6 => 8.
 * 
 * 1 + 2 + 5 => 8.
 * 
 * 1 + 7 => 8.
 * 
 * 2 + 6 => 8.
 * 
 * Input : candidates = [2, 5, 2, 1, 2] , target = 5
 * 
 * Output : [ [1, 2, 2] , [5] ]
 * 
 * Explanation : The combinations sum up to target are
 * 
 * 1 + 2 + 2 => 5.
 * 
 * 5 => 5.
 */
public class _07CombinationSum2 {

	public static void main(String[] args) {
		int[] arr = {2, 1, 2, 7, 6, 1, 5};
		int target = 8;
		System.out.println(combinationSum(arr, target));
	}
	
	private static List<List<Integer>> combinationSum(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		Arrays.sort(arr);
		combinationSumLoop(arr.length, 0, inner, result, arr, target);
		return result;
	}

	private static void printSubSequence(
			int n, 
			int idx, 
			List<Integer> inner, 
			List<List<Integer>> result,
			int[] arr) {
		if(idx == n) {
			result.add(new ArrayList<Integer>(inner));
			return;
		}
		// Pick
		inner.add(arr[idx]);
		printSubSequence(n, idx + 1, inner, result, arr);
		// Not Pick
		inner.remove(inner.size()-1);
		printSubSequence(n, idx + 1, inner, result, arr);
	}
	
	private static void combinationSumLoop(
										int n,
										int idx,
										List<Integer> inner,
										List<List<Integer>> result,
										int[] arr,
										int target) {
		if(target == 0) {
			result.add(new ArrayList<Integer>(inner));
			return;
		}
		if(target < 0) {
			return;
		}
		for(int i = idx; i < n; i++) {
			// Handle Duplicates
			if(i > idx && arr[i-1] == arr[i]) {
				continue;
			}
			inner.add(arr[i]);
			combinationSumLoop(n, i+1, inner, result, arr, target - arr[i]);
			inner.remove(inner.size()-1);
		}
	}
}
