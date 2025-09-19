package Step_15_Graphs.Lec2;

/**
 * An image is represented by a 2-D array of integers, each integer representing
 * the pixel value of the image. Given a coordinate (sr, sc) representing the
 * starting pixel (row and column) of the flood fill, and a pixel value
 * newColor, "flood fill" the image.
 * 
 * To perform a flood fill, consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same colour as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same colour as the starting pixel), and so on. Replace the
 * colour of all of the aforementioned pixels with the newColor.
 * 
 * Input: image = [ [1, 1, 1], [1, 1, 0], [1, 0, 1] ], sr = 1, sc = 1, newColor
 * = 2
 * 
 * Output: [ [2, 2, 2], [2, 2, 0], [2, 0, 1] ]
 * 
 * Explanation: From the center of the image with position (sr, sc) = (1, 1)
 * (i.e., the red pixel), all pixels connected by a path of the same color as
 * the starting pixel (i.e., the blue pixels) are colored with the new color.
 * 
 * Note the bottom corner is not colored 2, because it is not 4-directionally
 * connected to the starting pixel.
 */
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
