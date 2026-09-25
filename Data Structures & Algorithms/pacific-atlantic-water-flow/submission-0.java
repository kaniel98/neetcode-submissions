class Solution {
    int maxRow;
    int maxCol;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        maxRow = heights.length;
        maxCol = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();
        // Marker for both atlantic and pacific
        boolean[][] pacific = new boolean[maxRow][maxCol];
        boolean[][] atlantic = new boolean[maxRow][maxCol];

        // Top and bottom row
        for (int col = 0; col < maxCol; col++) {
            checkFlow(pacific, 0, col, Integer.MIN_VALUE, heights);
            checkFlow(atlantic, maxRow - 1, col, Integer.MIN_VALUE, heights);
        }

        for (int row = 0; row < maxRow; row++) {
            checkFlow(pacific, row, 0, Integer.MIN_VALUE, heights);
            checkFlow(atlantic, row, maxCol - 1, Integer.MIN_VALUE, heights);
        }

        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    res.add(List.of(row, col));
                }
            }
        }

        return res;
    }

    private void checkFlow(boolean[][] visited, int row, int col, int prevHeight, int[][] heights) {
        // if out of bounds, we will skip
        if (row < 0 || col < 0 || row == maxRow || col == maxCol) {
            return;
        }

        // If it is visited
        if (visited[row][col] || heights[row][col] < prevHeight) {
            return;
        }

        visited[row][col] = true;

        checkFlow(visited, row + 1, col, heights[row][col], heights);
        checkFlow(visited, row - 1, col, heights[row][col], heights);
        checkFlow(visited, row, col + 1, heights[row][col], heights);
        checkFlow(visited, row, col - 1, heights[row][col], heights);
    }
}