class Solution {
public void islandsAndTreasure(int[][] grid) {
        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;

        // Add all the exit points to the queue first
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();
            List<Coordinate> neighbours = islandAndTreasureGetNeighbours(currentCoordinate, n, m);
            for (Coordinate neighbour : neighbours) {
                if (grid[neighbour.r][neighbour.c] == Integer.MAX_VALUE) { // Means not visited
                    grid[neighbour.r][neighbour.c] = 1 + grid[currentCoordinate.r][currentCoordinate.c];
                    queue.add(neighbour);
                }
            }
        }
    }

    private List<Coordinate> islandAndTreasureGetNeighbours(Coordinate currentCoordinate, int n, int m) {
        List<Coordinate> neighbours = new ArrayList<>();
        int[] deltaRow = new int[]{0, 1, 0, -1};
        int[] deltaCol = new int[]{1, 0, -1, 0};

        for (int i = 0; i < deltaRow.length; i++) {
            int newRow = currentCoordinate.r + deltaRow[i];
            int newCol = currentCoordinate.c + deltaCol[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                neighbours.add(new Coordinate(newRow, newCol));
            }
        }
        return neighbours;
    }


    private static class Coordinate {
        int r;
        int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
