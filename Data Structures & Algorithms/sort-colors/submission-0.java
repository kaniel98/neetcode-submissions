class Solution {
    public void sortColors(int[] nums) {
        // Left and right pointers - Keep track of latest 0 and latest 2
        // Third pointer to keep of processed position
        // Everytime 0 is detected, swap and increment 
        // Everytime 2 is detected, swap and dont increment
        int left = 0;
        int right = nums.length - 1; 
        int i = 0;

        // We don't need to go past right
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i); 
                left ++;
                i ++; 
            } else if (nums[i] == 2) {
                swap(nums, i , right);
                right --; 
                // No need to increment 0, incase it is a 0
            } else {
                i ++; // Handling 1 cases 
            }
        } 
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp; 
    }
}