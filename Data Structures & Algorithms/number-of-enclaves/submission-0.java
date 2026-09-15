class Solution {
    public int numEnclaves(int[][] grid) {
        // Mark the edges first before proceeding with the actual marking 
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int row = 0; row < rowLen; row ++) {
            getIslandSize(grid, row, 0);
            getIslandSize(grid, row, colLen - 1);
        }

        for (int col = 0; col < colLen; col ++) {
            getIslandSize(grid, 0, col); 
            getIslandSize(grid, rowLen -1, col);
        }

        int res = 0;
        for (int row = 0; row < rowLen; row ++) {
            for (int col = 0; col < colLen; col ++) {
                if (grid[row][col] == 1) {
                    res += getIslandSize(grid, row, col);
                }
            }
        }

        return res;
    }

    private int getIslandSize(int[][] grid, int row, int col) {
        if (col < 0 || row < 0 || col >= grid[0].length || row >= grid.length
            || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0; // Mark as visited;

        return 1 + getIslandSize(grid, row + 1, col) + getIslandSize(grid, row - 1, col)
            + getIslandSize(grid, row, col + 1) + getIslandSize(grid, row, col - 1);
    }
}