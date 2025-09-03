package Step_07_Recursion.Lec2.Revision;

import java.util.ArrayList;
import java.util.List;

/**
 * Provided with a goal integer target and an array of unique integer
 * candidates, provide a list of all possible combinations of candidates in
 * which the selected numbers add up to the target. The combinations can be
 * returned in any order.
 * 
 * A candidate may be selected from the pool an infinite number of times. There
 * are two distinct combinations if the frequency of at least one of the
 * selected figures differs.
 * 
 * The test cases are created so that, for the given input, there are fewer than
 * 150 possible combinations that add up to the target.
 * 
 * If there is no possible subsequences then return empty vector.
 * 
 * Examples: Input : candidates = [2, 3, 5, 4] , target = 7
 * 
 * Output : [ [2, 2, 3] , [3, 4] , [5, 2] ]
 * 
 * Explanation :
 * 
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
 * times.
 * 
 * 5 and 2 are candidates, and 5 + 2 = 7.
 * 
 * 3 and 4 are candidates, and 3 + 4 = 7.
 * 
 * There are total three combinations.
 * 
 * Input : candidates = [2], target = 1
 * 
 * Output : []
 * 
 * Explanation : There is no way we can choose the candidates to sum up to
 * target.
 * 
 */
public class _06CombinationSum {

	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 4};
		int target = 7;
		System.out.println(combinationSum(arr, target));
	}
	
	private static List<List<Integer>> combinationSum(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		combinationSumLoop(arr.length, 0, inner, result, arr, target);
		return result;
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
			inner.add(arr[i]);
			combinationSumLoop(n, i, inner, result, arr, target - arr[i]);
			inner.remove(inner.size()-1);
		}
	}
}
