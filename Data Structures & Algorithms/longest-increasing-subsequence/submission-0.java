class Solution {

    // Need to record both the start and the current index we are on
    private int[][] maxLength;

    public int lengthOfLIS(int[] nums) {
        maxLength = new int[nums.length][nums.length + 1];
        for (int[] sub : maxLength) {
            Arrays.fill(sub, -1); 
        }

        return getMaxLength(nums, -1, 0);
    }

    private int getMaxLength(int[] nums, int prevPosition, int currPosition) {
        if (currPosition == nums.length) {
            return 0;
        }

        int memoIndex = prevPosition + 1;

        if (maxLength[currPosition][memoIndex] > -1) {
            return maxLength[currPosition][memoIndex];
        }

        // But we would basically check against the prev
        int skip = getMaxLength(nums, prevPosition, currPosition + 1); 
        int take = 0; 
        if (prevPosition == -1 || nums[currPosition] > nums[prevPosition]) {
            take = 1 + getMaxLength(nums, currPosition, currPosition + 1);
        }

        return maxLength[currPosition][memoIndex] = Math.max(skip, take);
    }
}