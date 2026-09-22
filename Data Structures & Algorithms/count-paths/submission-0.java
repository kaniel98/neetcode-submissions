class Solution {
    public int uniquePaths(int m, int n) {
        if (n <= 1) {
            return 1;
        }

        // We will only recieve from two locations, top or to the left 
        // Because we will only go to right or go down
        // Construct an array of [m][n] 
        // Iteratively increase row by row 
        int[][] pathsTracker = new int[m][n];
        
        // First row essentially only one way to get to there 
        Arrays.fill(pathsTracker[0], 1);

        // First column also essentially only one way to get there
        for (int i = 0; i < m; i ++) {
            pathsTracker[i][0] = 1; 
        }

        // Iterate through the remainder
        for (int row = 1; row < m; row ++) {
            for (int col = 1; col < n; col ++) {
                // Paths will be top plus left
                pathsTracker[row][col] = pathsTracker[row -1][col] + pathsTracker[row][col -1]; 
            }
        }

        // Towards the end, we will just return the bottom left
        return pathsTracker[m -1][n -1];
    }
}
