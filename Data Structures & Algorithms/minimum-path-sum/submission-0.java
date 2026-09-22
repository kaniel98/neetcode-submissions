class Solution {
    public int minPathSum(int[][] grid) {
        // Similar approach to unique, but instead we keep track of cost
        if (grid[0].length == 0) {
            return 0;
        }

        int[] minTracker = new int[grid[0].length];
        // Fill the first row
        for (int i = 0; i < grid[0].length; i++) {
            if (i == 0) {
                minTracker[i] = grid[0][i];
                continue;
            }
            minTracker[i] = minTracker[i - 1] + grid[0][i];
        }

        // From there we will populate it
        for (int row = 1; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (col == 0) {
                    minTracker[col] = grid[row][col] + minTracker[col];
                    continue;
                }

                // Else it will be top, current and left;
                minTracker[col] =
                    grid[row][col] + Math.min(minTracker[col], minTracker[col - 1]);
            }
        }

        // Return the last
        return minTracker[grid[0].length - 1];
    }
}