/*
	Flood Fill (LeetCode #733)
*/
class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int color)
	{
        int originalColor = image[sr][sc];
        
        if (originalColor == color) // if starting pixel already has new color, then do nothing
		{
            return image;
        }
        
        dfs(image, sr, sc, originalColor, color); // start depth-first search from given starting pixel
        
        return image; // return changed image
    }
    
    // method for doing flood fill recursively
    private void dfs(int[][] image, int row, int col, int originalColor, int newColor)
	{
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) // check bounds - if outside image, stop recursion
		{
            return;
        }
        
        if (image[row][col] != originalColor) // if current pixel is not original color, then stop recursion
		{
            return;
        }
        
        image[row][col] = newColor; // change pixel color
        
        // move in all four directions
        dfs(image, row - 1, col, originalColor, newColor); // up
        dfs(image, row + 1, col, originalColor, newColor); // down
        dfs(image, row, col - 1, originalColor, newColor); // left
        dfs(image, row, col + 1, originalColor, newColor); // right
    }
}