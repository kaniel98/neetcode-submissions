class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        return checkJumps(nums, 0, memo);
    }

    public boolean checkJumps(int[] nums, int curr, Boolean[] memo) {
        if (curr == nums.length - 1) {
            return true;
        }
        if (memo[curr] != null) {
            return memo[curr];
        }

        int lastPoint = Math.min(nums.length - 1, curr + nums[curr]);
        for (int i = lastPoint; i > curr; i--) {
            if (checkJumps(nums, i, memo)) {
                return memo[curr] = true;
            }
        }

        return memo[curr] = false;
    }
}