package Step_07_Recursion.Lec2;

import java.util.ArrayList;
import java.util.List;

public class _04Subset2 {

	public static void main(String[] args) {
//		int[] arr = {1, 2, 2};
		int[] arr = {5, 2, 1};
		System.out.println(powerSetLoopSum(arr));
	}

	private static List<List<Integer>> powerSet(int[] arr) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		powerSet(arr.length, 0, inner, result, arr);
		return result;
	}
	
	private static List<List<Integer>> powerSetLoop(int[] arr) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<Integer>();
		powerSetLoop(arr.length, 0, inner, result, arr);
		return result;
	}
	
	private static List<Integer> powerSetLoopSum(int[] arr) {
		List<Integer> result = new ArrayList<Integer>();
		powerSetLoopSum(arr.length, 0, result, arr, 0);
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
	
	private static void powerSetLoop(int n, int idx, List<Integer> inner, List<List<Integer>> result, int[] arr) {
		result.add(new ArrayList<Integer>(inner));
		for(int i = idx; i < n; i++) {
			// Handle duplicates
			if(i > idx && arr[i-1] == arr[i])
				continue;
			// Pick
			inner.add(arr[i]);
			powerSetLoop(n, i + 1, inner, result, arr);
			inner.remove(inner.size()-1);
		}
	}
	
	private static void powerSetLoopSum(int n, int idx, List<Integer> result, int[] arr, int sum) {
		result.add(sum);
		for(int i = idx; i < n; i++) {
			// Handle duplicates
			if(i > idx && arr[i-1] == arr[i])
				continue;
			// Pick
//			inner.add(arr[i]);
			powerSetLoopSum(n, i + 1, result, arr, sum + arr[i]);
//			inner.remove(inner.size()-1);
		}
	}

}
