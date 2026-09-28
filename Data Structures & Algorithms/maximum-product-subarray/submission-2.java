class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i ++) {
            int curr = nums[i];

            int prevMin = currMin;
            int prevMax = currMax;

            currMax = Math.max(curr, Math.max(curr * prevMax, curr * prevMin));
            currMin = Math.min(curr, Math.min(curr * prevMax, curr * prevMin));

            res = Math.max(res, currMax);
        }

        return res; 
    }
}
