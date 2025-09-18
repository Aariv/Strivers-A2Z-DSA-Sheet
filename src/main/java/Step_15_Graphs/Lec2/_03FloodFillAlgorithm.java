package Step_15_Graphs.Lec2;

public class _03FloodFillAlgorithm {
	
	public static void main(String[] args) {
		int[][] image = { 
				{ 1, 1, 1 },
				{ 1, 1, 0 },
				{ 1, 0, 1 } 
		};
		
        int sr = 1, sc = 1, newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);

        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        
        // If same as newColor, nothing changes (to avoid infinite loop)
        if (oldColor == newColor) return image;
        
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        // Boundary check
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;
        
        // Stop if not the target color
        if (image[r][c] != oldColor) return;
        
        // Recolor
        image[r][c] = newColor;
        
        // Explore 4 directions
        dfs(image, r + 1, c, oldColor, newColor); // down
        dfs(image, r - 1, c, oldColor, newColor); // up
        dfs(image, r, c + 1, oldColor, newColor); // right
        dfs(image, r, c - 1, oldColor, newColor); // left
    }
}
