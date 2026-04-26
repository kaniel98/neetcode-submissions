class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // First sort;
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        // Iterate through 
        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Solve by two sum 
            int currentSum = nums[i]; // Need to get this to zero             
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = currentSum + nums[left] + nums[right];
                if (temp < 0) {
                    left ++; 
                } else if (temp == 0) {
                    output.add(List.of(nums[i], nums[left], nums[right]));
                    left ++;
                    right --;
                    // Adjust both ends;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left ++;
                    }
                } else {
                    right --;
                }

                
            }
        }

        return output;
    }
}
