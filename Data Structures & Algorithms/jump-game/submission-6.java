class Solution {
    public boolean canJump(int[] nums) {
        boolean[] reachable = new boolean[nums.length];

        // Starting;
        reachable[nums.length - 1] = true; 
        for (int i = nums.length - 2; i >= 0; i --) {
            int end = Math.min(nums.length - 1, i + nums[i]);
            for (int idx = i + 1; idx <= end; idx ++) {
                if (reachable[idx]) {
                    reachable[i] = true; 
                    break;
                }
            }
        }

        return reachable[0] == true;
    }
}
