class Solution {
    public int shortestBridge(int[][] grid) {
        // Approach with bfs 
        // Mark all the seen ones with e.g., -1
        // From there, we will branch out from each seen one, until one of them approaches one that is -1 
        // Meaning it has reached the other island 
        
        Queue<Coordinate> queue = new ArrayDeque<>(); 
        boolean found = false;

        for (int row = 0; row < grid.length && !found; row ++) {
            for (int col = 0; col < grid[0].length && !found; col ++) {
                if (grid[row][col] == 1) {
                    dfs(grid, row, col, queue);
                    found = true;
                }
            } 
        }

        int res = 0;

        while (!queue.isEmpty()) {
            int count = queue.size(); 
            for (int i = 0; i < count; i ++) {
                Coordinate coord = queue.poll(); 
                int row = coord.row;
                int col = coord.col;

                int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] d : dirs) {
                    int nr = row + d[0];
                    int nc = col + d[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
                        if (grid[nr][nc] == 1) {
                            return res;
                        }
                        if (grid[nr][nc] == 0) {
                            grid[nr][nc] = 2;
                            queue.offer(new Coordinate(nr, nc));
                        }
                    }
                }
            }

            res ++;
        }

        return res;
    }

    private void dfs(int[][] grid, int r, int c, Queue<Coordinate> queue) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2;
        queue.offer(new Coordinate(r, c));
        dfs(grid, r - 1, c, queue);
        dfs(grid, r + 1, c, queue);
        dfs(grid, r, c - 1, queue);
        dfs(grid, r, c + 1, queue);
    }

    public static class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}