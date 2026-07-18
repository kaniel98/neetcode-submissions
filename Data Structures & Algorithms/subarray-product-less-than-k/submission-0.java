class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        // Sliding window, but the condition to move should be 
        // 1. If the array is already more then k, we need to reduce 
        int res = 0;
        int left = 0;
        int sum = 1; 

        for (int right = 0; right < nums.length; right ++) {
            sum *= nums[right]; 
            
            // Reduce the sum until it is below k 
            while (sum >= k) {
                sum /= nums[left]; 
                left ++;
            }

            res += (right - left + 1);
        }

        return res;
    }
}