class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col ++) {
                if (grid[row][col] == '1') {
                    System.out.println("Hello");
                    res ++;
                    markIsland(grid, row, col); 
                }
            }
        }

        return res;
    }

    public void markIsland(char[][] grid, int row, int col) {
        if (col < 0 || row < 0 || row > grid.length - 1 || col > grid[0].length - 1 || grid[row][col] == '0') {
            return; // Stop operation
        }

        // Mark the current one as 0 
        grid[row][col] = '0'; 

        // Proceed to iterate the remainder
        markIsland(grid, row - 1, col); // top
        markIsland(grid, row + 1, col); // bottom
        markIsland(grid, row, col + 1); // right;
        markIsland(grid, row, col - 1); // Left
    }
}
