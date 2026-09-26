class Solution {
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        dp = new Boolean[nums.length][target + 1];

        return dfs(nums, 0, target);
    }

    public boolean dfs(int[] nums, int position, int target) {
        if (position == nums.length) {
            return target == 0;
        }

        if (target < 0) {
            return false; // We don't want to proceed further as well
        }

        if (dp[position][target] != null) {
            return dp[position][target];
        }

        // Check for if we add / dont add 
        boolean result = dfs(nums, position + 1, target) || dfs(nums, position + 1, target - nums[position]);
        
        return dp[position][target] = result;
    }
}
