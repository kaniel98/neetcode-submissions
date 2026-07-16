class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int curr = 0;
    
        for (int num : nums) {
            if (num == 1) {
                curr ++;
                continue;
            }

            if (num == 0) {
                res = Math.max(res, curr);
                curr = 0;
            }
        }

        return Math.max(res, curr);
    }
}