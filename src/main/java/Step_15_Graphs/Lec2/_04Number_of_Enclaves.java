package Step_15_Graphs.Lec2;

import java.util.LinkedList;
import java.util.Queue;

public class _04Number_of_Enclaves {

	public int numEnclaves(int[][] grid) {
	    int n = grid.length, m = grid[0].length;

	    // Flood-fill all boundary lands
	    for (int i = 0; i < n; i++) {
	        if (grid[i][0] == 1) dfs(grid, i, 0);
	        if (grid[i][m-1] == 1) dfs(grid, i, m-1);
	    }
	    for (int j = 0; j < m; j++) {
	        if (grid[0][j] == 1) dfs(grid, 0, j);
	        if (grid[n-1][j] == 1) dfs(grid, n-1, j);
	    }

	    // Count remaining land
	    int count = 0;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (grid[i][j] == 1) count++;
	        }
	    }
	    return count;
	}

	private void dfs(int[][] grid, int r, int c) {
	    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) return;
	    grid[r][c] = 0; // mark as water (visited)
	    dfs(grid, r+1, c);
	    dfs(grid, r-1, c);
	    dfs(grid, r, c+1);
	    dfs(grid, r, c-1);
	}
	
	public int numEnclavesBFS(int[][] grid) {
	    int n = grid.length, m = grid[0].length;
	    Queue<int[]> q = new LinkedList<>();

	    // Push boundary lands into queue
	    for (int i = 0; i < n; i++) {
	        if (grid[i][0] == 1) { q.add(new int[]{i,0}); grid[i][0]=0; }
	        if (grid[i][m-1] == 1) { q.add(new int[]{i,m-1}); grid[i][m-1]=0; }
	    }
	    for (int j = 0; j < m; j++) {
	        if (grid[0][j] == 1) { q.add(new int[]{0,j}); grid[0][j]=0; }
	        if (grid[n-1][j] == 1) { q.add(new int[]{n-1,j}); grid[n-1][j]=0; }
	    }

	    // BFS flood-fill
	    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	    while (!q.isEmpty()) {
	        int[] cell = q.poll();
	        for (int[] d : dirs) {
	            int r = cell[0]+d[0], c = cell[1]+d[1];
	            if (r>=0 && c>=0 && r<n && c<m && grid[r][c]==1) {
	                grid[r][c]=0;
	                q.add(new int[]{r,c});
	            }
	        }
	    }

	    // Count enclaves
	    int count=0;
	    for (int i=0;i<n;i++){
	        for(int j=0;j<m;j++){
	            if(grid[i][j]==1) count++;
	        }
	    }
	    return count;
	}
}
