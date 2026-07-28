class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            int curr = Math.abs(nums[i]);

            // Else we will check 
            if (nums[curr - 1] < 0) {
                System.out.println(Arrays.toString(nums));
                return curr; 
            } else {
                nums[curr - 1] = -nums[curr - 1];
            }
        }
        return -1;
    }
}