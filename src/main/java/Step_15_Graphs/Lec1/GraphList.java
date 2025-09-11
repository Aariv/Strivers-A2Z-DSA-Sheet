package Step_15_Graphs.Lec1;

import java.util.ArrayList;
import java.util.List;

public class GraphList {

	public static void main(String[] args) {
		int n = 5;
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		
		// Initialize for the each list
		for(int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		addEdge(adjList, 0, 1);
		addEdge(adjList, 0, 2);
		addEdge(adjList, 1, 2);
		addEdge(adjList, 3, 4);

		// Print List
		for(int i = 0; i < n; i++) {
			System.out.print(i + " -> [");
			for(int neighbour : adjList.get(i)) {
				System.out.print(neighbour + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	private static void addEdge(List<List<Integer>> adjList, int i, int j) {
		adjList.get(i).add(j);
		adjList.get(j).add(i);
	}
}
