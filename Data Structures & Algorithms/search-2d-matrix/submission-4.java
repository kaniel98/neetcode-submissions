class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        
        // Do an outer binary search 
        while (left <= right) {
            int mid = (left + right) / 2;
            int[] curr = matrix[mid];

            if (curr[0] <= target && curr[curr.length - 1] >= target) {
                return innerBinarySearch(curr, target);
            }

            // Means it is bigger, we 
            if (curr[0] > target) {
                right = mid - 1; 
            } else {
                left = mid + 1;
            }

        }
        
        return false;
    }

    public boolean innerBinarySearch(int[] row, int target) {
        int left = 0;
        int right = row.length; 

        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == target) {
                return true;
            } 

            if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
