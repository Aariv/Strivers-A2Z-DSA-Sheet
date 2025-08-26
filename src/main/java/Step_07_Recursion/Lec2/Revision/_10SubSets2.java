package Step_07_Recursion.Lec2.Revision;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, which can have duplicate entries, provide the
 * power set.
 * 
 * Duplicate subsets cannot exist in the solution set. Return the answer in any
 * sequence.
 * 
 * Examples: Input : nums = [1, 2, 2]
 * 
 * Output : [ [ ] , [1] , [1, 2] , [1, 2, 2] , [2] , [2, 2] ]
 * 
 * Input : nums = [1, 2]
 * 
 * Output : [ [ ], [1] , [2] , [1, 2] ]
 * 
 */
public class _10SubSets2 {

	public static void main(String[] args) {
		int[] arr = {1, 2};
		System.out.println(subsetsWithDup(arr));
	}
	
	private static List<List<Integer>> subsetsWithDup(int[] arr) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		subsetsWithDup(arr.length, 0, inner, result, arr);
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
	
	private static void subsetsWithDup( int n,
									int idx,
									List<Integer> inner,
									List<List<Integer>> result,
									int[] arr) {
		result.add(new ArrayList<Integer>(inner));
		for(int i = idx; i < n; i++) {
			// Handle duplicates
			if(i > idx && arr[i-1] == arr[i])
				continue;
			inner.add(arr[i]);
			subsetsWithDup(n, i+1, inner, result, arr);
			inner.remove(inner.size()-1);
		}
	}
}
