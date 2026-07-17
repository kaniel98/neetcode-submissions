class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane's algorithm - 
        //  "does adding this element to the previous run make things better, or should I start a fresh run here?"
        int res = nums[0];
        int curr = 0;

        for (int i = 0; i < nums.length; i ++) {
            curr = Math.max(curr, 0); // Is it better to take the prev or just start from 0 again
            curr += nums[i];
            res = Math.max(curr, res);
        }

        return res;
    }
}
