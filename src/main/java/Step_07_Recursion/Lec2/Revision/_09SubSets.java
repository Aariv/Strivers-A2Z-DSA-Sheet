package Step_07_Recursion.Lec2.Revision;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers. Return array of sum of all subsets of the
 * array nums.
 * 
 * Output can be returned in any order.
 * 
 * 
 * Examples: Input : nums = [2, 3]
 * 
 * Output : [0, 2, 3, 5]
 * 
 * Explanation :
 * 
 * When no elements is taken then Sum = 0.
 * 
 * When only 2 is taken then Sum = 2.
 * 
 * When only 3 is taken then Sum = 3.
 * 
 * When element 2 and 3 are taken then sum = 2+3 = 5.
 * 
 * Input : nums = [5, 2, 1]
 * 
 * Output : [0, 1, 2, 3, 5, 6, 7, 8]
 * 
 * Explanation :
 * 
 * When no elements is taken then Sum = 0.
 * 
 * When only 5 is taken then Sum = 5.
 * 
 * When only 2 is taken then Sum = 2.
 * 
 * When only 1 is taken then Sum = 1.
 * 
 * When element 2 and 1 are taken then sum = 2+1 = 3.
 * 
 */
public class _09SubSets {

	public static void main(String[] args) {
		int[] arr = {2, 3};
		System.out.println(subsetsSum(arr));
	}
	
	private static List<Integer> subsetsSum(int[] arr) {
		List<Integer> result = new ArrayList<Integer>();
		subsetsSum(arr.length, 0, result, arr, 0);
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
	
	private static void subsetsSum( int n,
									int idx,
									List<Integer> result,
									int[] arr,
									int sum) {
		result.add(sum);
		for(int i = idx; i < n; i++) {
			// Handle duplicates
			if(i > idx && arr[i-1] == arr[i])
				continue;
			subsetsSum(n, i+1, result, arr, sum + arr[i]);
		}
	}
}
