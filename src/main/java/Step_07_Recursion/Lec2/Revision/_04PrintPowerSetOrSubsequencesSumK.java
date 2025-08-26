package Step_07_Recursion.Lec2.Revision;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums and an integer k. Return the number of non-empty
 * subsequences of nums such that the sum of all elements in the subsequence is
 * equal to k.
 * 
 * 
 * Examples: Input : nums = [4, 9, 2, 5, 1] , k = 10
 * 
 * Output : 2
 * 
 * Explanation : The possible subsets with sum k are [9, 1] , [4, 5, 1].
 * 
 * Input : nums = [4, 2, 10, 5, 1, 3] , k = 5
 * 
 * Output : 3
 * 
 * Explanation : The possible subsets with sum k are [4, 1] , [2, 3] , [5].
 * 
 */
public class _04PrintPowerSetOrSubsequencesSumK {

	public static void main(String[] args) {
		int[] arr = {4, 5, 1};
		int k = 6;
		System.out.println(countSubsequenceWithTargetSum(arr, k));
	}
	
	private static List<List<Integer>> countSubsequenceWithTargetSum(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		countSubsequenceWithTargetSumL(arr.length, 0, inner, result, arr, target);
		return result;
	}

	private static void countSubsequenceWithTargetSum(
			int n, 
			int idx, 
			List<Integer> inner, 
			List<List<Integer>> result,
			int[] arr, int target) {
		if(target == 0) {
			result.add(new ArrayList<Integer>(inner));
			return;
		}
		if(target < 0) {
			return;
		}
		// Pick
		inner.add(arr[idx]);
		countSubsequenceWithTargetSum(n, idx + 1, inner, result, arr, target - arr[idx]);
		// Not Pick
		inner.remove(inner.size()-1);
		countSubsequenceWithTargetSum(n, idx + 1, inner, result, arr, target - arr[idx]);
	}
	
	private static void countSubsequenceWithTargetSumL(
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
			inner.add(arr[i]);
			countSubsequenceWithTargetSumL(n, i+1, inner, result, arr, target - arr[i]);
			inner.remove(inner.size()-1);
		}
	}
}
