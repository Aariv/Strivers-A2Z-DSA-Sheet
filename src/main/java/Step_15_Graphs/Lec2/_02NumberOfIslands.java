package Step_15_Graphs.Lec2;

public class _02NumberOfIslands {

	public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {   // new island found
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
	
	private static void dfs(char[][] grid, int i, int j) {
        // Base case: out of bounds OR water
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        // Mark current cell as visited (sink the land)
        grid[i][j] = '0';

        // Explore all 4 directions
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }
}
