class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Prefix and postfix 
        int[] prefix = setupArrays(nums.length);
        int[] postfix = setupArrays(nums.length);

        // Populate prefix first
        for (int i = 1; i < nums.length; i ++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        // Populate postfix
        for (int i = nums.length; i > 0; i --) {
            postfix[i] = postfix[i + 1] * nums[i - 1];
        }

        int[] output = new int[nums.length]; 
        // Populate the output by multiplying prefix and postfix
        for (int i = 0; i < nums.length; i ++) {
            output[i] = prefix[i] * postfix[i + 2];
        }

        return output;
    }

    private int[] setupArrays(int numLength) {
        int[] temp = new int[numLength + 2];
        temp[0] = 1;
        temp[numLength + 1] = 1; 

        return temp;
    }
}  