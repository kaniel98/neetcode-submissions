class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    res = Math.max(res, getIslandSize(grid, row, col));
                }
            }
        }

        return res;
    }

    private int getIslandSize(int[][] grid, int row, int col) {
        if (col < 0 || row < 0 || row > grid.length - 1 || col > grid[0].length - 1
            || grid[row][col] == 0) {
            return 0; // Stop operation
        }

        // Mark the current one as 0
        grid[row][col] = 0;

        // Proceed to iterate the remainder
        return getIslandSize(grid, row - 1, col) + getIslandSize(grid, row + 1, col)
            + getIslandSize(grid, row, col + 1) + getIslandSize(grid, row, col - 1) + 1;
    }
}
