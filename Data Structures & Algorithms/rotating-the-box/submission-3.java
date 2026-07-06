class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        for (int i = 0; i < boxGrid.length; i ++) {
            pushStonesToEnd(boxGrid[i]); 
        }

        // Proceed to rotate
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] res = new char[n][m];
        for (int row = 0; row < m; row ++) {
            char[] currRow = boxGrid[row];
            
            for (int col = 0; col < n; col ++) {
                res[col][m - 1 - row] = currRow[col];
            }
        }

        return res;
    }

    public void pushStonesToEnd(char[] row) {
        int right = row.length - 1;

        for (int left = row.length - 1; left >= 0; left--) {
            if (row[left] == '*') {
                right = left - 1;
            } else if (row[left] == '#') {
                char temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                right--;
            }
        }
    }
}
