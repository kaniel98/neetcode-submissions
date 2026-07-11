class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int res = Integer.MAX_VALUE;

        while (left <= right) {
            if (nums[left] < nums[right]) {
                res = Math.min(nums[left], res);
                break;
            }

            // Move towards the smaller 
            int mid = (left + right) / 2; 
            int curr = nums[mid];
            res = Math.min(curr, res); 

            if (curr >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid -1; 
            }
        }

        return res;
    }
}
