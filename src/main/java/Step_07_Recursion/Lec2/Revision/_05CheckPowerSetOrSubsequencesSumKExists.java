package Step_07_Recursion.Lec2.Revision;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums and an integer k. R﻿eturn true if there exist
 * subsequences such that the sum of all elements in subsequences is equal to k
 * else false.
 * 
 * 
 * Examples: Input : nums = [1, 2, 3, 4, 5] , k = 8
 * 
 * Output : Yes
 * 
 * Explanation : The subsequences like [1, 2, 5] , [1, 3, 4] , [3, 5] sum up to
 * 8.
 * 
 * Input : nums = [4, 3, 9, 2] , k = 10
 * 
 * Output : No
 * 
 * Explanation : No subsequence can sum up to 10.
 * 
 */
public class _05CheckPowerSetOrSubsequencesSumKExists {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int k = 33;
		System.out.println(countSubsequenceWithTargetSum(arr, k).size() > 0 ? "Yes" : "No");
		System.out.println(countSubsequenceWithTargetSumExists(arr, k) ? "Yes" :"No");
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
		inner.remove(inner.size()-1);// backtrack
		// Not Pick
		countSubsequenceWithTargetSum(n, idx + 1, inner, result, arr, target - arr[idx]);
	}
	
	// Same as PowerSet and target sum, but return True if sum exists. 
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
	
	private static boolean countSubsequenceWithTargetSumExists(int[] arr, int target) {
		return countSubsequenceWithTargetSumExists(0, 0, arr, target);
	}
	
	private static boolean countSubsequenceWithTargetSumExists(int sum, int idx, int[] arr, int target) {
		// Base case: if we reached the end
        if (idx == arr.length) {
            return sum == target;
        }

        // Pick the element
        if (countSubsequenceWithTargetSumExists(sum + arr[idx], idx + 1, arr, target)) {
            return true;
        }

        // Not pick the element
        if (countSubsequenceWithTargetSumExists(sum, idx+1, arr, target)) {
            return true;
        }

        return false; // No subsequence found
	}
}
