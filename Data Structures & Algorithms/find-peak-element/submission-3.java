class Solution {
    public int findPeakElement(int[] nums) {
        // Handle if the edges are larger;
        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1; 
        }

        int left = 1;
        int right = nums.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Else go to the side where the side is bigger
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}