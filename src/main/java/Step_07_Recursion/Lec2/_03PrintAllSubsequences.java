package Step_07_Recursion.Lec2;

import java.util.ArrayList;
import java.util.List;

public class _03PrintAllSubsequences {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		System.out.println(powerSet(arr));
	}

	private static List<List<Integer>> powerSet(int[] arr) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		powerSet(arr.length, 0, inner, result, arr);
		return result;
	}

	private static void powerSet(int n, int idx, List<Integer> inner, List<List<Integer>> result, int[] arr) {
		if(idx == n) {
			result.add(new ArrayList<Integer>(inner));
			return;
		}
		
		// Pick
		inner.add(arr[idx]);
		powerSet(n, idx + 1, inner, result, arr);
		// Not Pick
		inner.remove(inner.size()-1);
		powerSet(n, idx + 1, inner, result, arr);
	}
}
