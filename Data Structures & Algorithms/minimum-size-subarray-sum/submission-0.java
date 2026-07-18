class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0; 

        for (int right = 0; right < nums.length; right ++) {
            sum += nums[right]; 
            // Move left if needed; 
            while (sum >= target) { // No need to worry about left being more then right
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left ++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;   
    }
}