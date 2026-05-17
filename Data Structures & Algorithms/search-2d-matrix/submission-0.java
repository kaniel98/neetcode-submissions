class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int[] curr = matrix[middle];

            if (curr[0] <= target && curr[curr.length - 1] >= target) {
                return binarySearch(curr, target);
            }

            if (curr[0] < target) {
                left = middle + 1;
            } else {
                right = middle -1;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int middle = (left + right) / 2;
            int curr = nums[middle];

            if (curr == target) {
                return true;
            }

            if (curr < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }
}
