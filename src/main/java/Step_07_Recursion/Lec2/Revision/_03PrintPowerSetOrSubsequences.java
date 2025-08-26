package Step_07_Recursion.Lec2.Revision;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers nums of unique elements. Return all possible
 * subsets (power set) of the array.
 * 
 * Do not include the duplicates in the answer.
 * 
 * Examples: Input : nums = [1, 2, 3]
 * 
 * Output : [ [ ] , [1] , [2] , [1, 2] , [3] , [1, 3] , [2, 3] , [1, 2 ,3] ]
 * 
 * Input : nums = [1, 2]
 * 
 * Output : [ [ ] , [1] , [2] , [1,2] ]
 * 
 */
public class _03PrintPowerSetOrSubsequences {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		System.out.println(printSubSequence(arr));
	}
	
	private static List<List<Integer>> printSubSequence(int[] arr) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		printSubSequenceLoop(arr.length, 0, inner, result, arr);
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
	
	private static void printSubSequenceLoop(
										int n,
										int idx,
										List<Integer> inner,
										List<List<Integer>> result,
										int[] arr) {
		result.add(new ArrayList<Integer>(inner));
		for(int i = idx; i < n; i++) {
			inner.add(arr[i]);
			printSubSequenceLoop(n, i+1, inner, result, arr);
			inner.remove(inner.size()-1);
		}
	}
}
