class Solution {
    public int rob(int[] nums) {
        // Observe the pattern
        // At the end of the day
        // if i dont rob the current, my max will be n - 1
        // If i rob the current, my max will be n - 2 + current
        // Thus, each position should contain the max out of the two
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int houseOne = nums[0];
        int houseTwo = Math.max(nums[0], nums[1]);
        int placeHolder = 0;

        for (int i = 2; i < nums.length; i ++) {
            placeHolder = Math.max(houseTwo, houseOne + nums[i]);

            houseOne = houseTwo;
            houseTwo = placeHolder;
        }

        return placeHolder;
    }
}
