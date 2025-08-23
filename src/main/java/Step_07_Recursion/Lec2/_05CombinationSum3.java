package Step_07_Recursion.Lec2;

import java.util.ArrayList;
import java.util.List;

public class _05CombinationSum3 {

	public static void main(String[] args) {
		int k = 3;
		int target = 7;
		System.out.println(combinationSum(k, target));
	}

	private static List<List<Integer>> combinationSum(int k, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		// Mistake 2: Start with the index 1
		combinationSum(k, 1, inner, result, target);
		return result;
	}

	private static void combinationSum(int k, int idx, List<Integer> inner, List<List<Integer>> result, int target) {
		if(inner.size() == k && target == 0) {
			result.add(new ArrayList<Integer>(inner));
			return;
		}
		for(int i = idx; i <= 9; i++) {
			// Mistake 3 
			if(target < i) {
				break;
			}
			// Pick
			inner.add(i);
			// Mistake 1: i wans't passed
			combinationSum(k, i+1, inner, result, target - i);
			inner.remove(inner.size()-1);
		}
	}

}
