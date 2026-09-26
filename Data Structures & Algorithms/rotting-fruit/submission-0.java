class Solution {
    public int orangesRotting(int[][] grid) {
        // Get count of oranges
        // Get locations of rotten oranges
        // BFS - Put the rotten oranges into the queue
        // Repeat until empty 
        // Check number of oranges left
        Queue<int[]> queue = new ArrayDeque<>();
        int oranges = 0;

        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col ++) {
                if (grid[row][col] == 1) {
                    oranges ++;
                    continue; 
                }

                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                    continue; 
                }
            }
        }

        int rounds = 0;

        while (!queue.isEmpty() && oranges > 0) {
            int count = queue.size();

            for (int i = 0; i < count; i ++) {
                int[] coord = queue.poll();
                int row = coord[0];
                int col = coord[1];

                // Put the surrounding into it 
                if (row - 1 >= 0) {
                    if (grid[row - 1][col] == 1) {
                        grid[row - 1][col] = 2;
                        oranges--;
                        queue.offer(new int[]{row - 1, col});
                    }
                }
                if (col - 1 >= 0) {
                    if (grid[row][col - 1] == 1) {
                        grid[row][col - 1] = 2;
                        oranges--;
                        queue.offer(new int[]{row, col - 1});
                    }
                }
                if (row + 1 < grid.length) {
                    if (grid[row + 1][col] == 1) {
                        grid[row + 1][col] = 2;
                        oranges--;
                        queue.offer(new int[]{row + 1, col});
                    }
                }
                if (col + 1 < grid[0].length) {
                    if (grid[row][col + 1] == 1) {
                        grid[row][col + 1] = 2;
                        oranges--;
                        queue.offer(new int[]{row, col + 1});
                    }
                }
            }

            rounds++;
        }
        

        return oranges == 0 ? rounds : -1;
    }
}