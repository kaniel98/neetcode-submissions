class Solution {
    public int pivotIndex(int[] nums) {
        // Construct prefix sum 
        // Basically as long as sum before = sum after, it means it is the pivot 

        int[] prefix = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            prefix[i] = sum;
        }

        // Iterate through the prefix array
        for (int i = 0; i < prefix.length; i ++) {
            int leftSide = i == 0 ? 0 : prefix[i -1];
            int rightSide = prefix[prefix.length -1] - prefix[i];

            if (leftSide == rightSide) {
                return i;
            }
        }

        return -1; 
    }
}