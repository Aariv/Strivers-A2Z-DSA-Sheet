package Step_07_Recursion.Lec2.Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Determine all possible set of k numbers that can be added together to equal n
 * while meeting the following requirements:
 * 
 * There is only use of numerals 1 through 9. A single use is made of each
 * number.
 * 
 * Return list of every feasible combination that is allowed. The combinations
 * can be returned in any order, but the list cannot have the same combination
 * twice.
 * 
 * Examples: Input : k = 3 , n = 7
 * 
 * Output : [ [1, 2, 4] ]
 * 
 * Explanation :
 * 
 * 1 + 2 + 4 = 7
 * 
 * There are no other valid combinations.
 * 
 * Input : k = 3, n = 9
 * 
 * Output : [[1, 2, 6],[1, 3, 5],[2, 3, 4]]
 * 
 * Explanation :
 * 
 * 1 + 2 + 6 = 9
 * 
 * 1 + 3 + 5 = 9
 * 
 * 2 + 3 + 4 = 9
 * 
 * There are no other valid combinations.
 */
public class _08CombinationSum3 {

	public static void main(String[] args) {
//		int[] arr = {2, 1, 2, 7, 6, 1, 5};
		int input = 3, target = 7;
		System.out.println(combinationSum(input, target));
	}
	
	private static List<List<Integer>> combinationSum(int n, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		combinationSumLoop(n, 1, inner, result, target);
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
										int target) {
		if(inner.size() == n && target == 0) {
			result.add(new ArrayList<Integer>(inner));
			return;
		}
		for(int i = idx; i <= 9; i++) {
			if(target < i) {
				break;
			}
			inner.add(i);
			combinationSumLoop(n, i + 1, inner, result, target - i);
			inner.remove(inner.size()-1);
		}
	}
}
