class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right ++) {
            int count = 1;
            while (right + 1 < nums.length && nums[right + 1] == nums[right]) {
                right ++; 
                count ++;
            }

            // Proceed to set left to be of this value 
            for (int i = 0; i < Math.min(2, count); i++) {
                nums[left] = nums[right];
                left ++;
            }
        }

        return left; 
    }
}