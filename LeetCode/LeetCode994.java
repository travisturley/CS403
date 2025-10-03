/*
	Rotting Oranges (LeetCode #994)
*/
class Solution
{
    public int orangesRotting(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        for (int r = 0; r < rows; r++) // Initialize queue with all rotten oranges
        {
            for (int c = 0; c < cols; c++)
            {
                if (grid[r][c] == 2)
                {
                    queue.offer(new int[]{r, c, 0}); // {row, col, time}
                }
                else if (grid[r][c] == 1)
                {
                    freshCount++;
                }
            }
        }   

        if (freshCount == 0) return 0; // If no fresh oranges
		
        int minutes = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) // Breadth-First Search
        {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int time = current[2];
            minutes = Math.max(minutes, time);
            
            for (int[] d : directions)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1)
                {
                    grid[nr][nc] = 2; // rot the fresh orange
                    freshCount--;
                    queue.offer(new int[]{nr, nc, time + 1});
                }
            }
        }

        return freshCount == 0 ? minutes : -1; // If any fresh orange remains, return -1. Else, return max minutes it took to rot all oranges.
    }
}