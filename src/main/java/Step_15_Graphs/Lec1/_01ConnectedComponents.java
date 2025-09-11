package Step_15_Graphs.Lec1;

import java.util.ArrayList;
import java.util.List;

public class _01ConnectedComponents {

	public static void main(String[] args) {
//		Nodes: 0, 1, 2, 3, 4
//		Edges: [[0,1], [1,2], [3,4]]
		
		int[][] edges = {{0,1}, {1,2}, {3,4}};
		
		int result = countComponents(5, edges);
		System.out.println(result);
	}

	private static int countComponents(int n, int[][] edges) {
		// Build List
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		for(int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for(int[] e: edges) {
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
		}
		
		boolean[] visited = new boolean[n];
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(i, adjList, visited);
				count++;
			}
		}
		return count;
	}

	private static void dfs(int i, List<List<Integer>> adjList, boolean[] visited) {
		visited[i] = true;
		for(int nei: adjList.get(i)) {
			if(!visited[nei]) {
				dfs(nei, adjList, visited);
			}
		}
	}
}
