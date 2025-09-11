package Step_15_Graphs.Lec1;

public class GraphMatrix {

	public static void main(String[] args) {
		int n = 5;
		int[][] matrix = new int[5][5];
		
		addEdge(matrix, 0, 1);
		addEdge(matrix, 0, 2);
		addEdge(matrix, 1, 2);
		addEdge(matrix, 3, 4);

		// Print Matrix
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void addEdge(int[][] matrix, int i, int j) {
		matrix[i][j] = 1;
		matrix[j][i] = 1;
	}
}
