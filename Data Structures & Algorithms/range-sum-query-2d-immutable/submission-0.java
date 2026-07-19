class NumMatrix {

    private int[][] prefixSumMatrix;

    public NumMatrix(int[][] matrix) {
        prefixSumMatrix = new int[matrix.length][];

        for (int i = 0; i < matrix.length; i ++) {
            int[] currRow = matrix[i];
            int[] currPrefix = new int[currRow.length];

            // Construct the prefix 
            int sum = 0;
            for (int idx = 0; idx < currRow.length; idx ++) {
                sum += currRow[idx];
                currPrefix[idx] = sum;
            }

            prefixSumMatrix[i] = currPrefix;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row ++) {
            int[] prefix = prefixSumMatrix[row];

            if (col1 == 0) {
                sum += prefix[col2];
                continue; 
            }

            // Else we will just add the range
            sum += prefix[col2] - prefix[col1 - 1];
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */