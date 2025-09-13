package Step_15_Graphs.Lec2;

/**
 * Given an undirected graph with V vertices. Two vertices u and v belong to a
 * single province if there is a path from u to v or v to u. Find the number of
 * provinces. The graph is given as an n x n matrix adj where adj[i][j] = 1 if
 * the ith city and the jth city are directly connected, and adj[i][j] = 0
 * otherwise.
 * 
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 * 
 * Input: adj=[ [1, 0, 0, 1], [0, 1, 1, 0], [0, 1, 1, 0], [1, 0, 0, 1] ]
 * 
 * Output: 2
 * 
 * Explanation:In this graph, there are two provinces: [1, 4] and [2, 3]. City 1
 * and city 4 have a path between them, and city 2 and city 3 also have a path
 * between them. There is no path between any city in province 1 and any city in
 * province 2.
 * 
 * Input: adj= [ [1, 0, 1], [0, 1, 0], [1, 0, 1] ]
 * 
 * Output: 2
 * 
 * Explanation: The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and
 * city 3 has a path between them they belong to a single province. City 2 has
 * no path to city 1 or city 3 hence it belongs to another province.
 */
public class _01NumberOfProvinces {
	
	public static void main(String[] args) {
		int[][] isConnected = { 
				{ 1, 1, 0 }, 
				{ 1, 1, 0 }, 
				{ 0, 0, 1 } 
		};
		System.out.println(numProvinces(isConnected)); // Output: 2
	}

	public static int numProvinces(int[][] adj) {
		int n = adj.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++; // one new province found
            }
        }
        return count;
	}

	private static void dfs(int i, int[][] adj, boolean[] visited) {
		visited[i] = true;
		for(int j = 0; j < adj.length; j++) {
			if(adj[i][j] == 1 && !visited[j]) {
				dfs(j, adj, visited);
			}
		}
	}
}
