class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right ++) {
            while (right + 1 < nums.length && nums[right + 1] == nums[right]) {
                right ++; 
            }

            // Proceed to set left to be of this value 
            nums[left] = nums[right];
            left ++; 
        }

        System.out.println(Arrays.toString(nums));
        return left; 
    }
}